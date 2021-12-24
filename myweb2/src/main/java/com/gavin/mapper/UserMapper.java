package com.gavin.mapper;

import com.gavin.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
Integer searchUser(String name, String pwd);
}