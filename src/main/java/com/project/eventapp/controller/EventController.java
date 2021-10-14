package com.project.eventapp.controller;

import com.project.eventapp.model.Event;
import com.project.eventapp.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;

    @GetMapping("/")
    public String getEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/editEvent/{id}")
    public String getEditEvent(Model model, @PathVariable("id") Long id) {
        Event eventToEdit = eventRepository.findById(id).orElse(null);
        model.addAttribute("event", eventToEdit);
        return "editEvent";
    }

    @PostMapping("/editEvent/{id}")
    public RedirectView postEditEvent(@ModelAttribute Event editedEvent, @PathVariable("id") Long id) {
        editedEvent.setId(id);
        eventRepository.save(editedEvent);
        return new RedirectView("/events"); // na razie powrót do events
    }

}
