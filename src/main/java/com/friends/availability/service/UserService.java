package com.friends.availability.service;

import com.friends.availability.model.User;
import com.friends.availability.model.enums.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserService {

    @Autowired
    HomeService homeService;

    public Optional<User> getUserByHomeIdAndUserId(String homeId, String userId){
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        homeService.getHomeByHomeId(homeId).flatMap(home -> home.getUsers().stream().filter(user -> user.getId().equals(userId)).findFirst()).ifPresent(userAtomicReference::set);
        return  Optional.ofNullable(userAtomicReference.get());
    }

    public Optional<User> setUserAvailabilityByHomeIdAndUserId(String homeId, String userId, Availability availability){
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        homeService.getHomeByHomeId(homeId).flatMap(home -> home.getUsers().stream().filter(user -> user.getId().equals(userId)).findFirst()).ifPresent(user ->{
            user.setAvailability(availability);
            userAtomicReference.set(user);
        } );
        return  Optional.ofNullable(userAtomicReference.get());
    }


}
