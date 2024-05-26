package com.example.swifty.dto;

import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a user with details such as ID, username, email, first name, last name, and birthdate.
 * Contains a static method to create a UserDTO object from a User entity and an Individual entity.
 */

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String birthdate;

    /**
     * Static method to create a UserDTO object from a User entity and an Individual entity.
     * @param currentUser The User entity.
     * @param currentUserIndividual The Individual entity.
     * @return UserDTO object populated with user details.
     */
    public static UserDTO getUserDTO(User currentUser, Individual currentUserIndividual) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(currentUser.getUserId());
        userDTO.setUsername(currentUser.getUsername());
        userDTO.setEmail(currentUser.getEmail());
        userDTO.setFirstName(currentUserIndividual.getFirstName());
        userDTO.setLastName(currentUserIndividual.getLastName());
        userDTO.setBirthdate(currentUserIndividual.getBirthdate());
        return userDTO;
    }
}
