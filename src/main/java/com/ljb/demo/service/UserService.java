package com.ljb.demo.service;

import com.ljb.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> quertAllUser();

    int saveUserInfo(User user);

    User queryUser(String username);
}
