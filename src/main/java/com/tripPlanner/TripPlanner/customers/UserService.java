package com.tripPlanner.TripPlanner.customers;

import com.tripPlanner.TripPlanner.exceptions.AccountExistedException;
import com.tripPlanner.TripPlanner.exceptions.UserAlreadyExistException;
import com.tripPlanner.TripPlanner.user.User;
import com.tripPlanner.TripPlanner.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String signUp(User user) throws UserAlreadyExistException, AccountExistedException {
        if(isAlreadyExist(user.getUsername())){
            throw new UserAlreadyExistException();
        }
        else if(isAlreadyExist(user)){
            throw new AccountExistedException();
        }
        userRepository.save(user);
        return "signed up successfully";
    }

    private boolean isAlreadyExist(User user) {
        return userRepository.findByEmail(user.getEmail()) != null;
    }

    private boolean isAlreadyExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
