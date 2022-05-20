package ru.ksenideni.fitnesscenter.events;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDTO {
    private Long id;

    private String name;

    private String description;

    private String tagDay;

    private String time;

}
