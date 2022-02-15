package com.friends.availability.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Home {
    private String id;
    private List<User> users;
}
