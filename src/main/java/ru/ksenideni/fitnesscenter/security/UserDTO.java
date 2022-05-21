package ru.ksenideni.fitnesscenter.security;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    String username;

    String password;

}
