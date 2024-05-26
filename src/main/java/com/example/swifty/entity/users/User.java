package com.example.swifty.entity.users;

import com.example.swifty.utils.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Entity class representing a user.
 * Contains properties such as user ID, username, email, password, user type, and references to Individual and Company entities.
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

    /**
     * Setter method for hashing the password using BCrypt.
     * @param password The password to be hashed.
     */
    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Method to check if a provided password matches the hashed password.
     * @param password The password to be checked.
     * @return true if the password matches, false otherwise.
     */
    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}
