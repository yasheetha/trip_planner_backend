package com.tripPlanner.TripPlanner.user;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "username cannot be null")
    private String username;
    @NotNull(message = "email cannot be null")
    @Email
    private String email;
    @NotNull(message = "password cannot be null")
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role=Role.USER;

    public User() {
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
