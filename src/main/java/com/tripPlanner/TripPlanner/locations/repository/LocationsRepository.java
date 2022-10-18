package com.tripPlanner.TripPlanner.locations.repository;

import com.tripPlanner.TripPlanner.locations.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Locations,Integer> {

}
