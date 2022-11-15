package com.tripPlanner.TripPlanner.locations.repository;

import com.tripPlanner.TripPlanner.locations.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationsRepository extends JpaRepository<Locations,Integer> {
    Optional<Locations> findByCity(String cityName);

    @Query("SELECT city FROM Locations")
    List<String> findCity();

    @Query("SELECT id FROM Locations WHERE city like %:locationName%")
    int findIdByCity(@Param("locationName") String locationName);
}
