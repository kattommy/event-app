package com.project.eventapp.service;

import com.project.eventapp.model.Event;
import com.project.eventapp.repository.EventRepository;

import java.util.List;
import java.util.Optional;

public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAllEvents() {

        return repository.findAll();
    }

    public Event saveEvents(Event event) {

        return repository.save(event);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Event> findEventById(Long id) {
        return repository.findById(id);
    }


}
