package com.example.swifty.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * This is the company entity.
 * The company has a one-to-one relation with user.
 */
@Getter
@Setter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;
    private String registerNumber;

    @OneToOne
    @JoinColumn
    private User user;
    public Company(){}
}
