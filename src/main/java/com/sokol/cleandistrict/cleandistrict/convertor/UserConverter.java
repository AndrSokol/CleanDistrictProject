package com.sokol.cleandistrict.cleandistrict.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sokol.cleandistrict.cleandistrict.entity.ContactEntity;
import com.sokol.cleandistrict.cleandistrict.entity.UserEntity;
import com.sokol.cleandistrict.cleandistrict.mapper.ContactMapper;
import com.sokol.cleandistrict.cleandistrict.mapper.UserMapper;
import com.sokol.cleandistrict.cleandistrict.model.Contact;
import com.sokol.cleandistrict.cleandistrict.model.User;

@Service
public class UserConverter {
    public List<User> getUsers(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            users.add(getUser(userEntity));
        });
        return users;
    }

    public User getUser(UserEntity userEntity) {
        User user = UserMapper.INSTANCE.userEntityToUser(userEntity);
        return user;
    }

    public Contact getContact(ContactEntity contactEntity) {
        return ContactMapper.INSTANCE.contactEntityToContact(contactEntity);
    }
}
