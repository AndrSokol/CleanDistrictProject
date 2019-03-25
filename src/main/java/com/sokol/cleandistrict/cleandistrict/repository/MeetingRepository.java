package com.sokol.cleandistrict.cleandistrict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sokol.cleandistrict.cleandistrict.entity.MeetingEntity;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingEntity, Integer> {
}
