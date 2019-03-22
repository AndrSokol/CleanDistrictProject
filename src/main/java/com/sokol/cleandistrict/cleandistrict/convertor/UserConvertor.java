package com.sokol.cleandistrict.cleandistrict.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sokol.cleandistrict.cleandistrict.entity.ContactEntity;
import com.sokol.cleandistrict.cleandistrict.entity.UserEntity;
import com.sokol.cleandistrict.cleandistrict.model.Contact;
import com.sokol.cleandistrict.cleandistrict.model.User;

@Service
public class UserConvertor {
    public List<User> getUsers(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            User user = getUser(userEntity);

            users.add(user);
        });
        return users;
    }

    public User getUser(UserEntity userEntity) {
        List<Contact> contacts = getContacts(userEntity.getContactList());

        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setContactList(contacts);
        return user;
    }

    public List<Contact> getContacts(List<ContactEntity> contactEntities) {

        if(contactEntities == null){
            return null;
        }

        List<Contact> contacts = new ArrayList<>();

        contactEntities.forEach(contactEntity -> {
            Contact contact = getContact(contactEntity);

            contacts.add(contact);
        });
        return contacts;
    }

    public Contact getContact(ContactEntity contactEntity) {
        Contact contact = new Contact();
        contact.setId(contactEntity.getId());
        contact.setType(contactEntity.getType());
        contact.setValue(contactEntity.getType());
        return contact;
    }
}
