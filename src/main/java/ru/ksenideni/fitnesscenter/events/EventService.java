package ru.ksenideni.fitnesscenter.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ksenideni.fitnesscenter.training.Training;
import ru.ksenideni.fitnesscenter.training.TrainingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final TrainingService trainingService;
    private final EventCreatingMapper eventCreatingMapper;
    private final EventMapper eventMapper;

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::fromEntity).toList();
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public void create(EventCreatingDTO event) {
        Event savedEvent=eventCreatingMapper.fromDTO(event, trainingService.getByName(event.getTrainingName()));
        eventRepository.save(savedEvent);
    }
}
