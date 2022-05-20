package ru.ksenideni.fitnesscenter.training;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    public void deleteById(Long id) {
        trainingRepository.deleteById(id);
    }

    public void create(Training training) {
        trainingRepository.save(training);
    }

    public Training getByName(String name) {
        return trainingRepository.getByName(name);
    }
}
