package ru.ksenideni.fitnesscenter.events;

import lombok.*;
import ru.ksenideni.fitnesscenter.training.Training;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "day_of_week")
    @Enumerated(EnumType.ORDINAL)
    private DayOfWeek dayOfWeek;
}
