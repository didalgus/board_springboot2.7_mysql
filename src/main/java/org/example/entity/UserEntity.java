package org.example.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserEntity {

    private Long seq;
    private String id;
    private String name;
    private String password;
    private String authority;
    private LocalDateTime create_at;

}
