package com.tripPlanner.TripPlanner.exceptions;

public class AccountExistedException extends Exception{
    public AccountExistedException() {
        super("already have an account");
    }
}
