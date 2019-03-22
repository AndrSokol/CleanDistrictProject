package com.sokol.cleandistrict.cleandistrict.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sokol.cleandistrict.cleandistrict.convertor.UserConvertor;
import com.sokol.cleandistrict.cleandistrict.entity.ContactEntity;
import com.sokol.cleandistrict.cleandistrict.entity.UserEntity;
import com.sokol.cleandistrict.cleandistrict.exception.UserNotFoundException;
import com.sokol.cleandistrict.cleandistrict.model.Contact;
import com.sokol.cleandistrict.cleandistrict.model.User;
import com.sokol.cleandistrict.cleandistrict.repository.ContactRepository;
import com.sokol.cleandistrict.cleandistrict.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserConvertor userConvertor;

    public List<User> getAll() {
        List<User> users = userConvertor.getUsers(userRepository.findAll());

        return users;
    }

    public User getById(int id) {
        return getUser(id);
    }

    private User getUser(int id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(! userEntity.isPresent()){
            throw new UserNotFoundException(String.format("User with id=%s not found", id));
        }

        return userConvertor.getUser(userEntity.get());
    }

    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        User savedUser = userConvertor.getUser(userRepository.save(userEntity));
        return savedUser;
    }

    public Contact createContactForUser(int id, Contact contact) {
        User user = getUser(id);

        UserEntity userEntity = new UserEntity();
        userEntity.setLastName(user.getLastName());
        userEntity.setLastName(user.getLastName());
        userEntity.setId(user.getId());

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setValue(contact.getValue());
        contactEntity.setUser(userEntity);
        contactEntity.setType(contact.getType());

        return userConvertor.getContact(contactRepository.save(contactEntity));
    }

    public List<Contact> getContactsForUser(int id) {
        List<Contact> contacts = getUser(id).getContactList();

        return contacts;
    }
}
