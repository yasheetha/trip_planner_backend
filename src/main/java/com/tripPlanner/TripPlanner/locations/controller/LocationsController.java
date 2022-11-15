package com.tripPlanner.TripPlanner.locations.controller;

import com.tripPlanner.TripPlanner.exceptions.LocationAlreadyExistedException;
import com.tripPlanner.TripPlanner.locations.model.Locations;
import com.tripPlanner.TripPlanner.locations.service.LocationsService;
import com.tripPlanner.TripPlanner.locations.service.LocationsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LocationsController {
    @Autowired
    LocationsServiceImp locationsService;

    @GetMapping("/locations")
    public List<Locations> fetchAllPlaces(){
        return locationsService.getLocationsList();
    }

    @PostMapping("/newLocation")
    public String saveNewPlace(@RequestBody Locations location) throws LocationAlreadyExistedException {
        return locationsService.saveLocation(location);
    }

    @GetMapping("/locationNames")
    public List<String> fetchLocationNames(){
        return locationsService.getLocationNames();
    }
}
