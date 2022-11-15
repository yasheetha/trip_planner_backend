package com.tripPlanner.TripPlanner.locations.service;

import com.tripPlanner.TripPlanner.exceptions.LocationAlreadyExistedException;
import com.tripPlanner.TripPlanner.locations.model.Locations;

import java.util.List;
import java.util.Optional;

public interface LocationsService {
    List<Locations> getLocationsList();
    String saveLocation(Locations location) throws LocationAlreadyExistedException;

    List<String> getLocationNames();

    int getLocationId(String locationName);

}
