package com.sokol.cleandistrict.cleandistrict.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.BatchSize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "meeting")
@Getter
@Setter
public class MeetingEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private Date date;

    @BatchSize(size = 100)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity organizer;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "meeting")
    private List<CommentEntity> comments;

    @BatchSize(size = 100)
    @ManyToMany(mappedBy = "meetings")
    private List<UserEntity> users;
}
