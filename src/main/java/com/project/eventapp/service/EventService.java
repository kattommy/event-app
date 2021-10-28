package com.project.eventapp.service;


import com.project.eventapp.model.Event;
import com.project.eventapp.model.User;
import com.project.eventapp.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository repository;


    public List<Event> getAll() {
        return repository.findAll();
    }

    public void save(Event event) {
        repository.save(event);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Event getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Event getWithParticipantsById(long id) {
        return repository.findWithParticipantsById(id)
                .orElseThrow(() -> new RuntimeException("brak eventu"));
    }


    public List<Event> getAllPastByUser(User user) {
        return repository.findAllPastByUser(user);
    }

    public void saveParticipantForAnEvent(User user, Event event) {
        event.getParticipants().add(user);
        repository.save(event);
    }
}
