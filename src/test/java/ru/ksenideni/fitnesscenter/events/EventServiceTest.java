package ru.ksenideni.fitnesscenter.events;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ksenideni.fitnesscenter.EventCreatingDTO;
import ru.ksenideni.fitnesscenter.training.Training;
import ru.ksenideni.fitnesscenter.training.TrainingService;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {
    @Mock
    private EventRepository eventRepository;
    @Mock
    private TrainingService trainingService;
    @Mock
    private EventCreatingMapper eventCreatingMapper;
    @Mock
    private EventMapper eventMapper;
    @InjectMocks
    private EventService eventService;

    List<Event> events = List.of(
            new Event(
                    1L,
                    new Training(2L, "trainingName1", "trainingDescription1"),
                    LocalTime.of(12, 15, 0),
                    LocalTime.of(13, 15, 0),
                    DayOfWeek.MON)
            ,
            new Event(
                    2L,
                    new Training(2L, "trainingName2", "trainingDescription2"),
                    LocalTime.of(13, 20, 0),
                    LocalTime.of(17, 00, 0),
                    DayOfWeek.FRI)
    );

    @Test
    void findAll() {
        //given
        when(eventRepository.findAll()).thenReturn(events);
        when(eventMapper.fromEntity(any(Event.class))).thenCallRealMethod();
        //when
        List<EventDTO> eventDTOS = eventService.findAll();
        //then
        assertEquals(2, eventDTOS.size(), "Size of result should be equal 2");
        var event1 = eventDTOS.get(0);
        assertEquals(1L, event1.getId(), "id should be equal");
        var event2 = eventDTOS.get(1);
        assertEquals(2L, event2.getId(), "id should be equal");
    }

    @Test
    void deleteById() {
        //given
        long id=12L;
        //when
        eventService.deleteById(id);
        //then
        verify(eventRepository, times(1)).deleteById(id);
    }

    @Test
    void create() {
        //given
        var event = EventCreatingDTO.builder()
                .trainingName("name")
                .dayOfWeek(DayOfWeek.FRI)
                .startTime(LocalTime.of(16, 0, 0))
                .endTime(LocalTime.of(17, 0, 0))
                .build();
        when(eventCreatingMapper.fromDTO(any(EventCreatingDTO.class), any(Training.class))).thenCallRealMethod();
        when(trainingService.getByName(eq("name")))
                .thenReturn(new Training(2L, "name", "trainingDescription1"));
        //when
        eventService.create(event);
        //then
        verify(eventRepository, times(1)).save(any(Event.class));
    }
}