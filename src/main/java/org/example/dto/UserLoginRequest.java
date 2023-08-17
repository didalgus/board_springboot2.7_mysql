package org.example.dto;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String userId;
    private String userName;
    private String userPassword;
    private String userAuthority;
}
