package com.tripPlanner.TripPlanner.customers;

import com.sun.tools.jconsole.JConsoleContext;
import com.tripPlanner.TripPlanner.exceptions.AccountExistedException;
import com.tripPlanner.TripPlanner.exceptions.UserAlreadyExistException;
import com.tripPlanner.TripPlanner.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/signUp")
    public String signUp(@Valid @RequestBody SignupRequest signupRequest) throws UserAlreadyExistException, AccountExistedException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12, new SecureRandom());
        User user = new User(signupRequest.getUsername(), bCryptPasswordEncoder.encode(signupRequest.getPassword()), signupRequest.getEmail());
        return userService.signUp(user);
    }

    @GetMapping("/login")
    Map<String, Object> login(Principal principal) {
        System.out.println(principal);
        String username = principal.getName();
        System.out.println(username);
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("username", username);
        return userDetails;
    }

}
