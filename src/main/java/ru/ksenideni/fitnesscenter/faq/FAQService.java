package ru.ksenideni.fitnesscenter.faq;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FAQService {
    private final FAQRepository faqRepository;

    public List<FAQ> findAll() {
        return faqRepository.findAll();
    }
}
