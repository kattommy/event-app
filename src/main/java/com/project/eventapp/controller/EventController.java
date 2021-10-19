package com.project.eventapp.controller;

import com.project.eventapp.model.Event;
import com.project.eventapp.service.EventService;
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

    private final EventService eventService;

    @GetMapping
    public String getEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/addEvent")
    public String getAddEvent() {
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public RedirectView postAddEvent(@ModelAttribute("event") Event event) {
        eventService.saveEvent(event);
        return new RedirectView("/events");
    }

    @GetMapping("/editEvent/{id}")
    public String getEditEvent(Model model, @PathVariable("id") Long id) {
        Event eventToEdit = eventService.findEventById(id);
        model.addAttribute("event", eventToEdit);
        return "editEvent";
    }

    @PostMapping("/editEvent/{id}")
    public RedirectView postEditEvent(@ModelAttribute Event editedEvent, @PathVariable("id") Long id) {
        editedEvent.setId(id);
       eventService.saveEvent(editedEvent);
        return new RedirectView("/events"); // na razie powrót do events
    }

    @GetMapping("/deleteEvent/{id}")
    public String getDeleteEvent(Model model, @PathVariable("id") Long id) {
        Event eventToDelete = eventService.findEventById(id);
        model.addAttribute("event", eventToDelete);
        return "deleteEvent";
    }

    @PostMapping("/deleteEvent/{id}")
    public RedirectView postDeleteEvent(@PathVariable("id") Long id){
        eventService.deleteById(id);
        return new RedirectView("/events");
    }

}
