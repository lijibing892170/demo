package com.ljb.demo.service.impl;

import com.ljb.demo.dao.UserDao;
import com.ljb.demo.entity.User;
import com.ljb.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> quertAllUser() {
        return userDao.quertAllUser();
    }

    @Override
//    @Transactional
    public int saveUserInfo(User user) {
        if (null == user) {
            throw new NullPointerException("user is not null");
        }
        int i = userDao.saveUserInfo(user);
        return 0;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public User queryUser(String username) {
        User bbb1 = new User("bbb", 12);
        int bbb = userDao.saveUserInfo(bbb1);
        System.out.println("id=" + bbb1.id);
        User user = userDao.queryUserByName(username);
        if (bbb == 1) {
//            int i = userDao.saveUserInfo(new User(username, Integer.parseInt("123456")));
//            if (i < 0)
//            throw new RuntimeException("save user fail");
        }
        return user;
    }
}
