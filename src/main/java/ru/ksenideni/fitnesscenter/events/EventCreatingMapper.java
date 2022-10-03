package ru.ksenideni.fitnesscenter.events;

import org.springframework.stereotype.Component;
import ru.ksenideni.fitnesscenter.EventCreatingDTO;
import ru.ksenideni.fitnesscenter.training.Training;

@Component
public class  EventCreatingMapper {
    Event fromDTO(EventCreatingDTO eventDTO, Training training) {
        Event event = Event.builder()
                .training(training)
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .dayOfWeek(eventDTO.getDayOfWeek())
                .build();
        return event;
    }
}
