package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserJoinRequest;
import org.example.dto.UserLoginRequest;
import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String loginUser(UserLoginRequest userLoginRequest) {
        UserEntity user = userService.login(userLoginRequest);
        return user.getPassword();
    }

    @PostMapping("/user/create")
    public String createUser(@RequestBody @Valid UserJoinRequest userJoinRequest) {
        String result = userService.create(userJoinRequest);
        return result;
    }
}
