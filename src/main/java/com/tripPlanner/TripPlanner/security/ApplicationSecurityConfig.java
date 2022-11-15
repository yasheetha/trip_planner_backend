package com.tripPlanner.TripPlanner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/newCountry","/newLocation","/newPlace","/newState").hasAuthority("ROLE_ADMIN")
                .antMatchers("/countries","/locations","/places/**","/states","/signUp","/posts","/locationNames","/login","/getPosts/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  daoAuthenticationProvider;
    }

}
