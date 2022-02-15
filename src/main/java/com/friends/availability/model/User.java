package com.friends.availability.model;

import com.friends.availability.model.enums.Availability;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String id;
    private String fullName;
    private Availability availability;
}
