package com.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;

}
