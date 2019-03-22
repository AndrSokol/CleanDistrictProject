package com.sokol.cleandistrict.cleandistrict.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private MeetingEntity meeting;

}
