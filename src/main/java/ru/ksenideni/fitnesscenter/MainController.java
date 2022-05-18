package ru.ksenideni.fitnesscenter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ksenideni.fitnesscenter.events.EventService;
import ru.ksenideni.fitnesscenter.faq.FAQService;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final FAQService faqService;
    private final EventService eventService;
    @GetMapping()
    public String index(Model model){
        model.addAttribute("faqs", faqService.findAll());
        model.addAttribute("events", eventService.findAll());
        return "index";
    }
}
