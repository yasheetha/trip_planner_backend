package com.tripPlanner.TripPlanner.country;

import com.tripPlanner.TripPlanner.exceptions.CountryAlreadyExistedException;
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

    public String saveCountry(Country country) throws CountryAlreadyExistedException {
        if(isAlreadyExisted(country)){
            throw new CountryAlreadyExistedException();
        }
        countryRepository.save(country);
        return "country data saved successfully";
    }

    private boolean isAlreadyExisted(Country country) {
        return countryRepository.findByName(country.getName()).orElse(null) != null;
    }
}
