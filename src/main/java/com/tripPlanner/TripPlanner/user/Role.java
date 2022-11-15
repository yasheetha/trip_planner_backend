package com.tripPlanner.TripPlanner.user;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @NotNull(message = "role cannot be null")
//    private String name;
//
//    public Role() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public enum Role {
    ADMIN, USER;

    Role() {
    }
    //    private final int id;
//
//    Role(int id) {
//        this.id = id;
//    }
//
//    public int getId(){
//        return id;
//    }

}