package ru.ksenideni.fitnesscenter.rates;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RateController {
    private final RateService rateService;
}
