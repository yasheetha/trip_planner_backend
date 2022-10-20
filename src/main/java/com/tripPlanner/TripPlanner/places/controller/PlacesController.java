package com.tripPlanner.TripPlanner.places.controller;

import com.tripPlanner.TripPlanner.exceptions.PlaceAlreadyExistedException;
import com.tripPlanner.TripPlanner.places.model.Places;
import com.tripPlanner.TripPlanner.places.repository.PlacesRepository;
import com.tripPlanner.TripPlanner.places.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlacesController {
    @Autowired
    PlacesService placesService;

    @Autowired
    PlacesRepository placesRepository;

    @GetMapping("/locationId/{id}/places")
    public List<Places> fetchAllPlaces(@PathVariable int id){
        return placesService.getPlacesList(id);
        //return placesRepository.findAll();
    }

    @PostMapping("/newPlace")
    public String saveNewPlace(@RequestBody Places place) throws PlaceAlreadyExistedException {
        return placesService.savePlaces(place);
    }
}
