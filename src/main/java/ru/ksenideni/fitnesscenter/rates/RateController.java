package ru.ksenideni.fitnesscenter.rates;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("rates")
public class RateController {
    private final RateService rateService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("rates", rateService.findAll());
        return "rates/rates";
    }

    @GetMapping("/new")
    public String newFAQ(@ModelAttribute("rate") Rate rate) {
        return "rates/new";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        rateService.deleteById(id);
        return "redirect:/rates";
    }

    @PostMapping
    public String create(@ModelAttribute("rates") Rate rate) {
        rateService.create(rate);
        return "redirect:/rates";
    }
}
