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
}
