package com.tripPlanner.TripPlanner.exceptions;

public class CountryAlreadyExistedException extends Exception {
    public CountryAlreadyExistedException() {
        super("country already existed");
    }
}
