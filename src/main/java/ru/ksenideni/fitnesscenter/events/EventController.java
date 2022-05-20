package ru.ksenideni.fitnesscenter.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ksenideni.fitnesscenter.rates.Rate;

@Controller
@RequiredArgsConstructor
@RequestMapping("events")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "events/events";
    }

    @GetMapping("/new")
    public String newEvent(@ModelAttribute("event") EventCreatingDTO event) {
        return "events/new";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        eventService.deleteById(id);
        return "redirect:/events";
    }

    @PostMapping
    public String create(EventCreatingDTO event) {
        eventService.create(event);
        return "redirect:/events";
    }
}
