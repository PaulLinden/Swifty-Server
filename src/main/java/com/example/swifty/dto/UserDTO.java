package com.example.swifty.dto;

import com.example.swifty.entity.users.Individual;
import com.example.swifty.entity.users.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDTO {
        private Long id;
        private String username;
        private String email;
        private String name;
        private String lastName;
        private String birtDate;

        public static UserDTO getUserDTO(User currentUser, Individual currentUserIndividual) {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(currentUser.getUserId());
                userDTO.setUsername(currentUser.getUsername());
                userDTO.setEmail(currentUser.getEmail());
                userDTO.setName(currentUserIndividual.getFirstName());
                userDTO.setLastName(currentUserIndividual.getLastName());
                userDTO.setBirtDate(currentUserIndividual.getBirthdate());
                return userDTO;
        }
}
