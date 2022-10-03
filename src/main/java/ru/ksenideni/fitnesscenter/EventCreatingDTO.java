package ru.ksenideni.fitnesscenter;

import lombok.*;
import ru.ksenideni.fitnesscenter.events.DayOfWeek;

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
