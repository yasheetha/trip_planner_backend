//package com.tripPlanner.TripPlanner.locations;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tripPlanner.TripPlanner.TripPlannerApplication;
//import com.tripPlanner.TripPlanner.locations.controller.LocationsController;
//import com.tripPlanner.TripPlanner.locations.model.Locations;
//import com.tripPlanner.TripPlanner.locations.repository.LocationsRepository;
//import com.tripPlanner.TripPlanner.locations.service.LocationsService;
//import com.tripPlanner.TripPlanner.locations.service.LocationsServiceImp;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.mock;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class LocationsControllerIntegrationTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    LocationsRepository locationsRepository;
//
//    @Autowired
//    LocationsServiceImp locationsServiceImp;
//
//    @Autowired
//    LocationsController locationsController;
//
//    @BeforeEach
//    void beforeAll() {
//        locationsRepository.deleteAll();
//    }
//
//    @AfterEach
//    void afterAll() {
//        locationsRepository.deleteAll();
//    }
//
//    @Test
//    void shouldBeAbleToGetLocationDetails() throws Exception {
//        Locations location = new Locations("chennai");
//        locationsRepository.save(location);
//        List<Locations> locationsList = new ArrayList<>();
//        locationsList.add(location);
//
//        String response = "[{\"id\":\""+ 1 +"\",\"name\":\" chennai \"}]\n";
//        System.out.println(locationsRepository.findAll()+"=====================");
//
//        mockMvc.perform(get("/getLocations"))
//                .andExpect(content().json(
//                        response))
//                .andExpect(status().isOk());
//
//    }}
