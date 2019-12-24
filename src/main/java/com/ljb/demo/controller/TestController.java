package com.ljb.demo.controller;

import com.ljb.demo.entity.User;
import com.ljb.demo.service.UserService;
import com.ljb.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/aaa")
    public String aaa() {
        return "123456";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(String username,String password) {
        if (CommonUtils.isStringEmpty(username)) {
            throw new NullPointerException("the account cannot be empty");
        }
        if (CommonUtils.isStringEmpty(password)) {
            throw new NullPointerException("the password cannot be empty");
        }
        User user = userService.queryUser(username);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", user);
        return map;
    }

    @RequestMapping(value = "/queryAllUser", method = RequestMethod.GET)
    public Map<String, Object> queryUser() {
        List<User> users = userService.quertAllUser();
        if (CommonUtils.isListEmpty(users)) {
            throw new RuntimeException("is not query all data");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", users);
        return map;
    }

}
