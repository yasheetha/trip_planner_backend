package com.tripPlanner.TripPlanner.places.model;

import com.tripPlanner.TripPlanner.locations.model.Locations;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;

    @NotNull(message = "place name should not be null")
    private String placeName;

    @Column(length = 65555)
    private String about;

    public Places() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(int id) {
        this.location = new Locations(id,"");
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
//    public Places(int id, int locationId, String placeName, String image) {
//        super();
//        this.id = id;
//        this.locations = new Locations(locationId,"","");
//        this.placeName = placeName;
//        this.image = image;
//    }
//    public Places(Places place){
//        this.id = place.id;
//        this.locations = place.locations;
//        this.placeName = place.placeName;
//        this.image = place.image;
//    }
}
