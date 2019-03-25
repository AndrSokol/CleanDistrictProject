package com.sokol.cleandistrict.cleandistrict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sokol.cleandistrict.cleandistrict.convertor.UserConverter;
import com.sokol.cleandistrict.cleandistrict.entity.ContactEntity;
import com.sokol.cleandistrict.cleandistrict.entity.UserEntity;
import com.sokol.cleandistrict.cleandistrict.exception.UserNotFoundException;
import com.sokol.cleandistrict.cleandistrict.mapper.UserMapper;
import com.sokol.cleandistrict.cleandistrict.model.Contact;
import com.sokol.cleandistrict.cleandistrict.model.User;
import com.sokol.cleandistrict.cleandistrict.repository.ContactRepository;
import com.sokol.cleandistrict.cleandistrict.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserConverter userConverter;

    public List<User> getAll() {
        log.info("Retrieving all users");
        return userConverter.getUsers(userRepository.findAll());
    }

    public User getById(int id) {
        return getUser(id);
    }

    private User getUser(int id) {
        log.info(String.format("Retrieving user with id=%s", id));
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (!userEntity.isPresent()) {
            throw new UserNotFoundException(String.format("User with id=%s not found", id));
        }

        return userConverter.getUser(userEntity.get());
    }

    public User createUser(User user) {
        log.info(String.format("Creation user: %s", user));
        UserEntity userEntity = UserMapper.INSTANCE.userToUserEntity(user);

        return userConverter.getUser(userRepository.save(userEntity));
    }

    public Contact createContactForUser(int id, Contact contact) {
        log.info(String.format("Creation contact for user_id=%s. Contact info: %s", id, contact));
        UserEntity userEntity = UserMapper.INSTANCE.userToUserEntity(getUser(id));

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setValue(contact.getValue());
        contactEntity.setUser(userEntity);
        contactEntity.setType(contact.getType());

        return userConverter.getContact(contactRepository.save(contactEntity));
    }

    public List<Contact> getContactsForUser(int id) {
        log.info(String.format("Getting contacts for user_id=%s", id));
        return getUser(id).getContactList();
    }
}
