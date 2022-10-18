//package com.tripPlanner.TripPlanner.locations;
//
//import com.tripPlanner.TripPlanner.locations.model.Locations;
//import com.tripPlanner.TripPlanner.locations.repository.LocationsRepository;
//import com.tripPlanner.TripPlanner.locations.service.LocationsServiceImp;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class LocationsServiceImpTest {
//
//    private LocationsRepository locationsRepository;
//
//    @BeforeEach
//    void setUp() {
//        locationsRepository = mock(LocationsRepository.class);
//    }
//
//    @Test
//    void shouldBeAbleToStoreLocationsInformationWhenDataIsGiven() {
//        String locationName = "chennai";
//        LocationsServiceImp locationsService = new LocationsServiceImp(locationsRepository);
//        Locations location = new Locations(locationName);
//
//        locationsService.saveLocation(location);
//
//        verify(locationsRepository).save(any());
//    }
//
//    @Test
//    void shouldBeAbleToShowLocationDetailsWhenAsked() {
//        String locationName = "chennai";
//        LocationsServiceImp locationsService = new LocationsServiceImp(locationsRepository);
//        Locations location = new Locations(locationName);
//        locationsService.saveLocation(location);
//        List<Locations> locationsList = new ArrayList<>();
//        locationsList.add(location);
//
//        verify(locationsRepository).equals(locationsList);
//    }
//}
