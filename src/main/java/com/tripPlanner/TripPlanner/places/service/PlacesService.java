package com.tripPlanner.TripPlanner.places.service;

import com.tripPlanner.TripPlanner.exceptions.PlaceAlreadyExistedException;
import com.tripPlanner.TripPlanner.locations.model.Locations;
import com.tripPlanner.TripPlanner.locations.service.LocationsService;
import com.tripPlanner.TripPlanner.places.model.Places;
import com.tripPlanner.TripPlanner.places.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacesService {
    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    LocationsService locationsService;

    public List<Places> getPlacesList(String locationName) {
        int id = locationsService.getLocationId(locationName);
        return placesRepository.findByLocationId(id);
    }

    public String savePlaces(Places place) throws PlaceAlreadyExistedException {
        if(isAlreadyExisted(place)){
            throw new PlaceAlreadyExistedException();
        }
        placesRepository.save(place);
        return "place saved succesfully";
    }

    private boolean isAlreadyExisted(Places place) {
        return placesRepository.findByPlaceName(place.getPlaceName()).orElse(null) != null;
    }
}
