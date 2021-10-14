package com.project.eventapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 30)
    public String firstName;

    @Column(length = 30)
    public String lastName;

    @Column(length = 50)
    public String email;

    @Column(length = 30)
    public String password;

    //TODO relacja z eventami, komentarzami

}
