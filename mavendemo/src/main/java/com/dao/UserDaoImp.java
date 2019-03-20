package com.dao;

import com.bean.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImp implements UserDao {
    @Override
    public void show(User user) {
        System.out.println(user.getAge());
        System.out.println(user.getBirth());
        System.out.println(user.getName());
    }
}
