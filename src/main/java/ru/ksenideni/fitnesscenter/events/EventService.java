package ru.ksenideni.fitnesscenter.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ksenideni.fitnesscenter.EventCreatingDTO;
import ru.ksenideni.fitnesscenter.training.TrainingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final TrainingService trainingService;
    private final EventCreatingMapper eventCreatingMapper;
    private final EventMapper eventMapper;

    /***
     * Метод возвращает все события (тренировка и время)
     * @return лист доступных событий
     */
    public List<EventDTO> findAll() {
        List<EventDTO> allEvents = eventRepository.findAll().stream()
                .map(eventMapper::fromEntity).toList();
        System.out.println(allEvents);
        return allEvents;
    }

    /***
     * Метод для удаления курса
     * @param id - id курса, который нужно удалить
     */
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    /***
     * Метод для создания нового события
     * @param event - событие, состоящее из тренировка и времени проведения (расписания)
     */
    public void create(EventCreatingDTO event) {
        Event savedEvent = eventCreatingMapper.fromDTO(event, trainingService.getByName(event.getTrainingName()));
        eventRepository.save(savedEvent);
    }
}
