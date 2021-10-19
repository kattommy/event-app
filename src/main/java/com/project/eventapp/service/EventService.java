package com.project.eventapp.service;


import com.project.eventapp.model.Event;
import com.project.eventapp.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository repository;
  

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event saveEvent(Event event) {

        return repository.save(event);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Event findEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
