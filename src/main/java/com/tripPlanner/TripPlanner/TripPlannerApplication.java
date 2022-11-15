package com.tripPlanner.TripPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tripPlanner.TripPlanner", "com.tripPlanner.TripPlanner.user"})
@EnableAutoConfiguration
public class TripPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPlannerApplication.class, args);
	}

}



