package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserJoinRequest;
import org.example.dto.UserLoginRequest;
import org.example.entity.UserEntity;
import org.example.mapper.UserMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public UserEntity login(UserLoginRequest userLoginRequest) {
        return userMapper.selectUser(userLoginRequest);
    }


    public String create(UserJoinRequest userJoinRequest) {

         //userJoinRequest.setUserPassword(passwordEncoder.encode(userJoinRequest.getUserPassword()));

        if (userMapper.createUser(userJoinRequest) == 1) {
            return "OK";
        } else {
            return "FAIL";
        }

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserEntity> userList() {
        return userMapper.selectUsers();
    }

}
