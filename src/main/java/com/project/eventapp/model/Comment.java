package com.project.eventapp.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd.MM.yyyy - hh:mm")
    private Date creationDate;

    @Column(length = 1000)
    private String description;

    //TODO relacja z użytkownikiem, eventem
}
