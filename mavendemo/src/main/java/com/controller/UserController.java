package com.controller;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.UserService;
public class UserController {
    @Autowired
    UserService userService;

    public void show (User user){
        System.out.println(user.getAge());
        System.out.println(user.getBirth());
        System.out.println(user.getName());
    }
}
