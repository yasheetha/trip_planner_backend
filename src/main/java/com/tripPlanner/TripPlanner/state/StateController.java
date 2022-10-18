package com.tripPlanner.TripPlanner.state;

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
    public String setStates(@RequestBody State state){
        return stateService.saveState(state);
    }
}
