package com.sokol.cleandistrict.cleandistrict.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Contact> contactList;
//    private List<SocialNetwork> socialNetworkList;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
