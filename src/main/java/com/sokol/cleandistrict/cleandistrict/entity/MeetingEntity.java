package com.sokol.cleandistrict.cleandistrict.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "meeting")
public class MeetingEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity organizer;

    @OneToMany(mappedBy = "meeting")
    private List<CommentEntity> comments;

    @ManyToMany(mappedBy = "meetings")
    private List<UserEntity> users;
}
