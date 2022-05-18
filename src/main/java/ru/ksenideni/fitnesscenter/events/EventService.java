package ru.ksenideni.fitnesscenter.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::fromEntity).toList();
    }
}
