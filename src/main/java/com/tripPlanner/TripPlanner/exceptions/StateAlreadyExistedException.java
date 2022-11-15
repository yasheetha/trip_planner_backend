package com.tripPlanner.TripPlanner.exceptions;

public class StateAlreadyExistedException extends Exception {
    public StateAlreadyExistedException() {
        super("state already existed");
    }
}
