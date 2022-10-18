package com.tripPlanner.TripPlanner.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public String saveCountry(Country country) {
        countryRepository.save(country);
        return "country data saved successfully";
    }
}
