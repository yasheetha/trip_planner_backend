package com.tripPlanner.TripPlanner.places.service;

import com.tripPlanner.TripPlanner.places.model.Places;
import com.tripPlanner.TripPlanner.places.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesService {
    @Autowired
    PlacesRepository placesRepository;

    public List<Places> getPlacesList(int id) {
        return placesRepository.findByLocationId(id);
    }

    public String savePlaces(Places place){
        placesRepository.save(place);
        return "place saved succesfully";
    }
}
