package com.project.eventapp.controller;

import com.project.eventapp.model.Event;
import com.project.eventapp.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@AllArgsConstructor
@Controller
public class EventController {

    private final EventRepository eventRepository;

    @GetMapping("/events")
    public String getEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/addEvent")
    public String getAddEvent() {
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public RedirectView postAddEvent(@ModelAttribute("event") Event event) {
        eventRepository.save(event);
        return new RedirectView("/events");
    }


}
