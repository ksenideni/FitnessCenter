package ru.ksenideni.fitnesscenter.events;

import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public EventDTO fromEntity(Event event) {
        EventDTO eventDTO = EventDTO.builder().
                name(event.getTraining().getName())
                .description(event.getTraining().getDescription())
                .tagDay(event.getDayOfWeek().name().toLowerCase())
                .time(event.getStartTime().toString() + " - " + event.getEndTime().toString())
                .build();
        return eventDTO;
    }
}
