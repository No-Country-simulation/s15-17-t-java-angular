package org.example.coworkproject.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RegisterRequestDTO {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String repeatedPassword;
    private String profilePicture;

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(String name, String lastName, String email, String password, String repeatedPassword, String profilePicture) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.profilePicture = profilePicture;
    }
}
