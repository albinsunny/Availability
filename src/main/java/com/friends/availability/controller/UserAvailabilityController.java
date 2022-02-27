package com.friends.availability.controller;

import com.friends.availability.model.Home;
import com.friends.availability.model.User;
import com.friends.availability.model.enums.Availability;
import com.friends.availability.service.HomeService;
import com.friends.availability.service.UserService;
import com.friends.availability.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAvailabilityController {

    @Autowired
    HomeService homeService;

    @Autowired
    UserService userService;

    @GetMapping("/availability/reset")
    //TODO - Decommission when implementations are done
    public ResponseEntity<String> resetAvailabilities() {
        UserUtils.USER_HOMES = UserUtils.getHomes();
        return new ResponseEntity<>("Reset Successfully", HttpStatus.OK);
    }
    @GetMapping("/availability")
    public ResponseEntity<List<Home>> getAvailabilities() {

        return new ResponseEntity<>(homeService.getAllHomes(), HttpStatus.OK);
    }

    @GetMapping("/availability/{homeId}")
    public ResponseEntity<Home> getAvailabilityByHome(@PathVariable("homeId") String homeId) {
        Optional<Home> optionalHome = homeService.getHomeById(homeId);
        return optionalHome.map(home -> new ResponseEntity<>(home, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/availability/{homeId}/{userId}")
    public ResponseEntity<User> getAvailabilityByHomeAndUser(@PathVariable("homeId") String homeId,
                                                             @PathVariable("userId") String userId) {

        Optional<User> optionalUser = userService.getUserByHomeIdAndUserId(homeId, userId);
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/availability/{homeId}/{userId}/{availability}")
    public ResponseEntity<User> setAvailabilityByHomeAndUser(@PathVariable("homeId") String homeId,
                                                             @PathVariable("userId") String userId,
                                                             @PathVariable("availability") Availability availability) {

        Optional<User> optionalUser = userService.setUserAvailabilityByHomeIdAndUserId(homeId, userId,availability);
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
