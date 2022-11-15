package com.tripPlanner.TripPlanner.post;

import com.tripPlanner.TripPlanner.post.placesVisited.PlacesVisited;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class PostResponse {

    private int postId;
    private String username;
    private String locationName;
    private String experience;
    private int estimatedCost;
    private Date date;
    private int likes;
    private List<PlacesVisitedResponse> placesVisited;

    public PostResponse() {
    }

    public PostResponse(int postId, String username, String locationName, String experience, int estimatedCost, int likes, Date date, List<PlacesVisitedResponse> placesVisited) {
        this.postId = postId;
        this.username = username;
        this.locationName = locationName;
        this.experience = experience;
        this.estimatedCost = estimatedCost;
        this.date = date;
        this.likes = likes;
        this.placesVisited = placesVisited;
    }

    public String getUsername() {
        return username;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getExperience() {
        return experience;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public Date getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public List<PlacesVisitedResponse> getPlacesVisited() {
        return placesVisited;
    }

    public int getPostId() {
        return postId;
    }
}
