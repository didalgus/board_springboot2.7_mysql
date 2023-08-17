package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.dto.UserJoinRequest;
import org.example.dto.UserLoginRequest;
import org.example.entity.UserEntity;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id=#{userId} AND password=#{userPassword}")
    UserEntity selectUser(UserLoginRequest loginRequest);

    @Insert("INSERT INTO user (id, name, password, authority) VALUES (#{userId}, #{userName}, #{userPassword}, #{userAuthority})")
    int createUser(UserJoinRequest userJoinRequest);

}
