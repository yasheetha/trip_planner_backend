package com.tripPlanner.TripPlanner.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tripPlanner.TripPlanner.post.placesVisited.PlacesVisited;
import com.tripPlanner.TripPlanner.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Component
public class PostRequest {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD")
    @NotNull(message = "date cannot be null")
    private Date date;

    @JsonProperty
    private List<PlacesVisited> placesVisited;

    public PostRequest() {
    }

    public PostRequest(User user, String locationName, String experience, int estimatedCost, Date date, List<PlacesVisited> placesVisited) {
        System.out.println(placesVisited+" "+user);
        this.user = user;
        this.locationName = locationName;
        this.experience = experience;
        this.estimatedCost = estimatedCost;
        this.date = date;
        this.placesVisited = placesVisited;
    }


//    public PostRequest( String locationName, String experience, int estimatedCost, Date date) {
//        this.locationName = locationName;
//        this.experience = experience;
//        this.estimatedCost = estimatedCost;
//        this.date = date;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(int userId) {
        this.user = new User(userId,"","","");
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<PlacesVisited> getPlacesVisited() {
        return placesVisited;
    }

    public void setPlacesVisited(List<PlacesVisited> placesVisited) {
        this.placesVisited = placesVisited;
    }
}
