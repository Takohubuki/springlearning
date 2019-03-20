package com.service;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService{
    @Resource(name = "userDao")
    UserDao userDao;

    @Override
    public void show(User user) {

    }
}
