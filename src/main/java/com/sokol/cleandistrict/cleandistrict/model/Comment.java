package com.sokol.cleandistrict.cleandistrict.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Comment {
    private Integer id;
    private String text;
    private Integer userId;

    public Comment(String text) {
        this.text = text;
    }
}
