package com.sokol.cleandistrict.cleandistrict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sokol.cleandistrict.cleandistrict.model.Contact;
import com.sokol.cleandistrict.cleandistrict.model.User;
import com.sokol.cleandistrict.cleandistrict.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/users/{id}/contacts")
    public Contact createContact(@PathVariable int id, @RequestBody Contact contact){
        return userService.createContactForUser(id, contact);
    }

    @GetMapping("/users/{id}/contacts")
    public List<Contact> getContactsForUser(@PathVariable int id){
        return userService.getContactsForUser(id);
    }

}
