package com.tripPlanner.TripPlanner.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getCountriesDetails() {
        return countryService.getCountries();
    }

    @PostMapping("/newCountry")
    public String setCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

}
