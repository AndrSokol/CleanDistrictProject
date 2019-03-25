package com.sokol.cleandistrict.cleandistrict.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Meeting {
    private Integer id;
    private String title;
    private String description;
    private Date date;
    private Integer organizer_id;
    private List<Comment> comments;
    private List<User> users;

    public Meeting(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }
}
