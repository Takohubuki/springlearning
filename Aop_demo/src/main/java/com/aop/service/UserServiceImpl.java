package com.aop.service;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save");
    }
}
