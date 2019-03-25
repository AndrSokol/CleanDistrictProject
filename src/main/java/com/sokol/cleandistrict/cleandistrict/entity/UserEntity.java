package com.sokol.cleandistrict.cleandistrict.entity;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.BatchSize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "user")
    private List<ContactEntity> contactList;

    @OneToMany(mappedBy = "user")
    private List<CommentEntity> commentList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_meeting",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "meeting_id") }
    )
    private List<MeetingEntity> meetings;

    @OneToMany(mappedBy = "organizer")
    private List<MeetingEntity> organizedMeetings;


}
