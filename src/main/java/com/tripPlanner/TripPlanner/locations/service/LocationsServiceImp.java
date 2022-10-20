package com.tripPlanner.TripPlanner.locations.service;

import com.tripPlanner.TripPlanner.exceptions.LocationAlreadyExistedException;
import com.tripPlanner.TripPlanner.locations.model.Locations;
import com.tripPlanner.TripPlanner.locations.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsServiceImp implements LocationsService {

    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsServiceImp(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    @Override
    public List<Locations> getLocationsList(){
        return locationsRepository.findAll();
    }

    @Override
    public String saveLocation(Locations location) throws LocationAlreadyExistedException {
        if(isAlreadyExisted(location)){
            throw new LocationAlreadyExistedException();
        }
        locationsRepository.save(location);
        return "location saved successfully";
    }

    private boolean isAlreadyExisted(Locations location) {
        return locationsRepository.findByCity(location.getCity()).orElse(null) != null;
    }
}
