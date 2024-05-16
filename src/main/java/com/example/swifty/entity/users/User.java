package com.example.swifty.entity.users;

import com.example.swifty.utils.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

/*
* This is the main user entity.
* The user can be either an individual or company
* with a one-to-one relation
*/
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private UserType userType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @NonNull
    private Individual individual;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @NonNull
    private Company company;

    public User(){}

    // Setter for password with automatic hashing
    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to check if a provided password matches the hashed password
    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}
