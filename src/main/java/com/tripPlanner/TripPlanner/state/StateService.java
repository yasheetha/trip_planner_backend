package com.tripPlanner.TripPlanner.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public StateService() {
    }

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public String saveState(State state){
        stateRepository.save(state);
        return "state data saved successfully";
    }
}
