package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserJoinRequest;
import org.example.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public String create(UserJoinRequest userJoinRequest) {

         //userJoinRequest.setUserPassword(passwordEncoder.encode(userJoinRequest.getUserPassword()));

        if (userMapper.createUser(userJoinRequest) == 1) {
            return "OK";
        } else {
            return "FAIL";
        }

    }
}
