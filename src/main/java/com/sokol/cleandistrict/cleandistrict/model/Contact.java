package com.sokol.cleandistrict.cleandistrict.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Contact {
    private Integer id;
    private String type;
    private String value;

    public Contact(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
