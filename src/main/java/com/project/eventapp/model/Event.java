package com.project.eventapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

//    @DateTimeFormat(pattern = "dd-MM-yyyy'T'hh:mm")
    private LocalDateTime startDateTime; // FIXME

//    @DateTimeFormat(pattern = "dd-MM-yyyy'T'hh:mm")
    private LocalDateTime endDateTime; // FIXME

    @Column(length = 30)
    private String location;

    @Column(length = 1000)
    private String description;

    //TODO relacja z organizatorami, użytkownikami, zdjęcie(?)

}
