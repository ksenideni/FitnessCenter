package ru.ksenideni.fitnesscenter.training;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("training")
public class TrainingController {
    private final TrainingService trainingService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("trainings", trainingService.findAll());
        return "training/training";
    }

    @GetMapping("/new")
    public String newFAQ(@ModelAttribute("training") Training training) {
        return "training/new";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        trainingService.deleteById(id);
        return "redirect:/training";
    }

    @PostMapping
    public String create(@ModelAttribute("trainings") Training training) {
        trainingService.create(training);
        return "redirect:/training";
    }
}
