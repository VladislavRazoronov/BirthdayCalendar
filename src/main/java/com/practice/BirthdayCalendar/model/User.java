package com.practice.BirthdayCalendar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @JsonProperty(value = "Id")
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty(value = "Username")
    @Column(name = "username")
    String username;

    @JsonProperty(value = "Email")
    @Column(name = "email")
    String email;

    @JsonProperty(value = "Password")
    @Column(name = "password")
    String password;

}
