package com.tripPlanner.TripPlanner.locations.controller;

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
    @ResponseStatus(code = HttpStatus.OK)
    public List<Locations> fetchAllPlaces(){
        return locationsService.getLocationsList();
    }

    @PostMapping("/newLocation")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String saveNewPlace(@RequestBody Locations location){
        return locationsService.saveLocation(location);
    }
}
