package com.workshop.authenticationserver.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    @Id
    private int id;
    private String firstname;
    private String lastname;
//    @Column(unique=true)
    private String email;
    private String password;
    private boolean active = true;
    private LocalDate deletedAt;
    private LocalDateTime LastLoggedInAt;
    private String role;
    private String resetPasswordToken;

}