package com.tripPlanner.TripPlanner.locations.service;

import com.tripPlanner.TripPlanner.locations.model.Locations;

import java.util.List;

public interface LocationsService {
    List<Locations> getLocationsList();
    String saveLocation(Locations location);

}
