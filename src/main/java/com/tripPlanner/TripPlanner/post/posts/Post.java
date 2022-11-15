package com.tripPlanner.TripPlanner.post.posts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tripPlanner.TripPlanner.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty
    @NotNull(message = "user cannot be null")
    private User user;

    @JsonProperty
    @NotNull(message = "location name cannot be null")
    private String locationName;

    @Size(max = 65555)
    @JsonProperty
    private String experience;

    @JsonProperty
    private int estimatedCost;

    @JsonProperty
    private int likes=0;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD")
    private Date date;

    public Post() {
    }

    public Post(int id) {
        this.id = id;
    }

    public Post(User user, String locationName, String experience, int estimatedCost, Date date) {
        this.user = user;
        this.locationName = locationName;
        this.experience = experience;
        this.estimatedCost = estimatedCost;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
