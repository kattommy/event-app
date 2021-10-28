package com.project.eventapp.controller;

import com.project.eventapp.model.Comment;
import com.project.eventapp.model.Event;
import com.project.eventapp.model.User;
import com.project.eventapp.service.CommentService;
import com.project.eventapp.service.EventService;
import com.project.eventapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping
    public String getEvents(Model model) {
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "event/events";
    }

    @GetMapping("/past")
    public String getEventsPast(Model model, @AuthenticationPrincipal User user) {
        List<Event> events = eventService.getAllPastByUser(user);
        model.addAttribute("eventsPast", events);
        return "event/eventsPast";
    }


    @GetMapping("/addEvent")
    public String getAddEvent() {
        return "event/addEvent";
    }

    @PostMapping("/addEvent")
    public RedirectView postAddEvent(@ModelAttribute("event") Event event) {
        eventService.save(event);
        return new RedirectView("/events");
    }

    @GetMapping("/editEvent/{id}")
    public String getEditEvent(Model model, @PathVariable("id") Long id) {
        Event eventToEdit = eventService.getById(id);
        model.addAttribute("event", eventToEdit);
        return "event/editEvent";
    }

    @PostMapping("/editEvent/{id}")
    public RedirectView postEditEvent(@ModelAttribute Event editedEvent, @PathVariable("id") Long id) {
        editedEvent.setId(id);
        eventService.save(editedEvent);
        return new RedirectView("/events"); // na razie powrót do events
    }

    @GetMapping("/deleteEvent/{id}")
    public String getDeleteEvent(Model model, @PathVariable("id") Long id) {
        Event eventToDelete = eventService.getById(id);
        model.addAttribute("event", eventToDelete);
        return "event/deleteEvent";
    }

    @PostMapping("/deleteEvent/{id}")
    public RedirectView postDeleteEvent(@PathVariable("id") Long id) {
        eventService.deleteById(id);
        return new RedirectView("/events");
    }

    @GetMapping("/eventDetails/{id}")
    public String getEventDetails(Model model, @PathVariable("id") Long id) {
        Event eventToDisplay = eventService.getWithParticipantsById(id);
        model.addAttribute("event", eventToDisplay);
        List<Comment> allComments = commentService.findAllCommentsByEventsId(id);
        model.addAttribute("comments", allComments);
        return "event/eventDetails";
    }

    @PostMapping("/saveParticipant/forEvent/{eventId}")
    public String postSaveParticipant(@AuthenticationPrincipal User user, @PathVariable("eventId") Long eventId) {
        Event event = eventService.getById(eventId);
        eventService.saveParticipantForAnEvent(user, event);
        return "redirect:/events/eventDetails/" + eventId + "/?saved";
    }
}
