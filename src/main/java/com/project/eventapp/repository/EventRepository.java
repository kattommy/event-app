package com.project.eventapp.repository;

import com.project.eventapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    List<Event> findAllByOrganizer_Id(long id);

    Optional<Event> findWithParticipantsById(long id);
}
