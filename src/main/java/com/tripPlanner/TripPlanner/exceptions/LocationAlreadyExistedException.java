package com.tripPlanner.TripPlanner.exceptions;

public class LocationAlreadyExistedException extends Exception {
    public LocationAlreadyExistedException() {
        super("location already existed");
    }
}
