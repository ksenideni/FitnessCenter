package ru.ksenideni.fitnesscenter.training;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;
}
