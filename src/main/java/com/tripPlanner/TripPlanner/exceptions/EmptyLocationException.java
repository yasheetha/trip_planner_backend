package com.tripPlanner.TripPlanner.exceptions;

public class EmptyLocationException extends Exception{
    public EmptyLocationException() {
        super("location should not be empty");
    }
}
