package com.project.eventapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy - hh:mm")
    private Date startDateTime;

    @DateTimeFormat(pattern = "dd.MM.yyyy - hh:mm")
    private Date endDateTime;

    @Column(length = 30)
    private String location; //zdalnie / miasto

    @Column(length = 1000)
    private String description;

    //TODO relacja z organizatorami, zdjęcie(?)

}
