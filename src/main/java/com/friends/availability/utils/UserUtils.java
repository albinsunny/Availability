package com.friends.availability.utils;

import com.friends.availability.model.Home;
import com.friends.availability.model.User;
import com.friends.availability.model.enums.Availability;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {
    public static  List<Home> USER_HOMES= getHomes();

    public static List<Home> getHomes(){
        ArrayList<Home> homes = new ArrayList<>();
        homes.add(Home.builder().id("H1").users(getDummyUsers()).build());
        return homes;
    }

    public static List<User> getDummyUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(User.builder().id("SHD1").fullName("Anand").availability(Availability.AVAILABLE).build());
        users.add(User.builder().id("SHD2").fullName("Arly").availability(Availability.AVAILABLE).build());
        users.add(User.builder().id("SHD3").fullName("Athira").availability(Availability.AVAILABLE).build());
        users.add(User.builder().id("SHD4").fullName("Jyothish").availability(Availability.AVAILABLE).build());
        users.add(User.builder().id("SHD5").fullName("Roshan").availability(Availability.AVAILABLE).build());

        return users;
    }
}
