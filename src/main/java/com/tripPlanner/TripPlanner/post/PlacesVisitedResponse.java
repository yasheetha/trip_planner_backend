package com.tripPlanner.TripPlanner.post;

import org.springframework.stereotype.Component;

@Component
public class PlacesVisitedResponse {
    private String placeName;
    private float rating;
    private String about;

    public PlacesVisitedResponse() {
    }

    public PlacesVisitedResponse(String placeName, float rating, String about) {
        this.placeName = placeName;
        this.rating = rating;
        this.about = about;
    }

    public String getPlaceName() {
        return placeName;
    }

    public float getRating() {
        return rating;
    }

    public String getAbout() {
        return about;
    }
}
