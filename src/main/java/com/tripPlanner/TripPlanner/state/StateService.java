package com.tripPlanner.TripPlanner.state;

import com.tripPlanner.TripPlanner.exceptions.StateAlreadyExistedException;
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

    public String saveState(State state) throws StateAlreadyExistedException {
        if(isAlreadyExisted(state)){
            throw new StateAlreadyExistedException();
        }
        stateRepository.save(state);
        return "state data saved successfully";
    }

    private boolean isAlreadyExisted(State state) {
        return stateRepository.findByName(state.getName()).orElse(null) != null;
    }
}
