package com.project.eventapp.repository;

import com.project.eventapp.model.Event;
import com.project.eventapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e " +
            "FROM Event e JOIN e.participants p " +
            "WHERE p = :user AND e.endDateTime < current_time")
    List<Event> findAllPastByUser(@Param("user") User user);

    List<Event> findAllByOrganizer_Id(long id);

    Optional<Event> findWithParticipantsById(long id);
}
