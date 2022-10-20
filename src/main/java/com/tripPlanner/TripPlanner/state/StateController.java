package com.tripPlanner.TripPlanner.state;

import com.tripPlanner.TripPlanner.exceptions.StateAlreadyExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StateController {
    @Autowired
    StateService stateService;

    @GetMapping("/states")
    public List<State> getStates(){
        return stateService.getStates();
    }

    @PostMapping("/newState")
    public String setStates(@RequestBody State state) throws StateAlreadyExistedException {
        return stateService.saveState(state);
    }
}
