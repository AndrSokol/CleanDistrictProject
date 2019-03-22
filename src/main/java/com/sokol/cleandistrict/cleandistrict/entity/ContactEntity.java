package com.sokol.cleandistrict.cleandistrict.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "contact")
@Getter
@Setter
public class ContactEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
