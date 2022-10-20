package com.tripPlanner.TripPlanner.state;

import com.tripPlanner.TripPlanner.country.Country;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "state name cannot be empty")
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryId;

    public State() {
    }
    public State(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = new Country(countryId,"");
    }
}
