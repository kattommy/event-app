package com.project.eventapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Column(length = 30)
    private String location;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    private User organizer;

    @ManyToMany
    private Set<User> participants;

    public void removeParticipant(User user) {
        participants.remove(user);
    }
}
