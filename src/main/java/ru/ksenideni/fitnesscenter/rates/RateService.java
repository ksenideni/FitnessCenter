package ru.ksenideni.fitnesscenter.rates;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {
    private final RateRepository rateRepository;

    public List<Rate> findAll() {
        return rateRepository.findAll();
    }

    public void deleteById(Long id) {
        rateRepository.deleteById(id);
    }

    public void create(Rate rate) {
        rateRepository.save(rate);
    }
}
