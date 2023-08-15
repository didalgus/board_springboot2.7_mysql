package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserJoinRequest;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody @Valid UserJoinRequest userJoinRequest) {
        String result = userService.create(userJoinRequest);
        return result;
    }
}
