package com.example.swifty.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/*
 * This is the individual entity.
 * The individual has a one-to-one relation with user.
 */
@Getter
@Setter
@Entity
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String birthdate;

    @OneToOne
    @JoinColumn
    private User user;
    public Individual(){}
}
