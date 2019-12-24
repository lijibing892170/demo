package com.ljb.demo.dao;


import com.ljb.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> quertAllUser();

    int saveUserInfo(User user);

    User queryUserByName(String name);
}
