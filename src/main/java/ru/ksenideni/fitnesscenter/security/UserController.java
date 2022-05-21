package ru.ksenideni.fitnesscenter.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    // PUT localhost:8080/acc/password?username=vasya2002
    //    {"qwerty123"}
    @PutMapping("/acc/password")
    public void update(@RequestParam String username, @RequestBody String password) {
        userService.update(username, password);
    }


    @PostMapping("/registration")
    public void registerUser(@RequestBody UserDTO user) {
        userService.registerNewUserAccount(user);
    }
}
