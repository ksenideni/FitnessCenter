package ru.ksenideni.fitnesscenter.faq;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/faqs")
public class FAQController {
    private final FAQService faqService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("faqs", faqService.findAll());
        return "faqs/faqs";
    }

    @GetMapping("/new")
    public String newFAQ(@ModelAttribute("faq") FAQ faq) {
        return "faqs/new";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        faqService.deleteById(id);
        return "redirect:/faqs";
    }

    @PostMapping
    public String create(FAQ faq) {
        faqService.create(faq);
        return "redirect:/faqs";
    }
}
