package ru.ksenideni.fitnesscenter.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    private final UserDetailsManager userDetailsManager;

    public void registerNewUserAccount(UserDTO user) {
        userDetailsManager.createUser(
                User
                        .withUsername(user.getUsername())
                        .password(encoder.encode(user.getPassword()))
                        .authorities(new SimpleGrantedAuthority("ROLE_" + UserRole.USER.name()))
                        .build());
    }

    public void update(String username, String password) {
        UserDetails oldUser = userDetailsManager.loadUserByUsername(username);
        userDetailsManager.changePassword(oldUser.getPassword(), encoder.encode(password));
    }
}
