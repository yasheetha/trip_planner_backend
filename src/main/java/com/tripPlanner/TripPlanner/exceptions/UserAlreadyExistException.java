package com.tripPlanner.TripPlanner.exceptions;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException() {
        super("user with that username already existed ");
    }
}
