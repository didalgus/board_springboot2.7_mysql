package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.dto.UserJoinRequest;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (id, name, password) VALUES (#{userId}, #{userName}, #{userPassword})")
    int createUser(UserJoinRequest userJoinRequest);

}
