package com.tripPlanner.TripPlanner.exceptions;

public class PlaceAlreadyExistedException extends Exception {
    public PlaceAlreadyExistedException() {
        super("place already existed");
    }
}
