package com.tripPlanner.TripPlanner.locations.model;

import com.tripPlanner.TripPlanner.state.State;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "location name should not be null")
    private String city;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State stateId;

//    private String image;

    public Locations() {
    }

    public Locations(int id,String city) {
        this.id = id;
        this.city = city;
    }

    public Locations(String city) {
        this.city = city;
    }

//    public Locations(int id, String name, String image){
//        this.id = id;
//        this.name = name;
//        this.image = image;
//    }
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = new State(stateId,"");
    }
}
