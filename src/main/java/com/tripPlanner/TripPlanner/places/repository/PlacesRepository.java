package com.tripPlanner.TripPlanner.places.repository;

import com.tripPlanner.TripPlanner.places.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacesRepository extends JpaRepository<Places,Integer> {
    List<Places> findByLocationId(int id);
}
