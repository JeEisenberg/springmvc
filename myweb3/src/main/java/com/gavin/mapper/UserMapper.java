package com.gavin.mapper;

import com.gavin.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int addUser(User User);

}