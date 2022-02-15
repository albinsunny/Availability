package com.friends.availability.service;

import com.friends.availability.model.Home;
import com.friends.availability.model.User;
import com.friends.availability.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    public List<Home> getAllHomes(){
        return UserUtils.USER_HOMES;
    }

    public Optional<Home> getHomeById(String homeId){
         return getHomeByHomeId(homeId);
    }

    public Optional<Home> getHomeByHomeId(String homeId){
        return  UserUtils.USER_HOMES.stream().filter(home-> home.getId().equals(homeId)).findFirst();
    }

}
