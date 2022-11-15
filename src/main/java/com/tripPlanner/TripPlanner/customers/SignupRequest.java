package com.tripPlanner.TripPlanner.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Component
public class SignupRequest {
    @JsonProperty
    @NotNull(message = "username cannot be null")
    private String username;
    @JsonProperty
    @NotNull(message = "email cannot be null")
    @Email
    private String email;
    @JsonProperty
    @NotNull(message = "password cannot be null")
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
