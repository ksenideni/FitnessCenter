package ru.ksenideni.fitnesscenter.faq;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faqs")
public class FAQController {
    private final FAQService faqService;

    @GetMapping
    public List<FAQ> findAll() {
        return faqService.findAll();
    }
}
