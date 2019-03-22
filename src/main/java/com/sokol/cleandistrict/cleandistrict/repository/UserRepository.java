package com.sokol.cleandistrict.cleandistrict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sokol.cleandistrict.cleandistrict.entity.UserEntity;
import com.sokol.cleandistrict.cleandistrict.model.User;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
