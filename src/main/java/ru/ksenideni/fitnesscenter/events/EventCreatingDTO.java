package ru.ksenideni.fitnesscenter.events;

import lombok.*;

import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventCreatingDTO {

    private String trainingName;

    private LocalTime startTime;

    private LocalTime endTime;

    private DayOfWeek dayOfWeek;
}
