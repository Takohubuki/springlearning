package com.aop;

import com.aop.service.UserService;
import com.aop.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        UserService userService = (UserService) applicationContext.getBean("userDao");

        userService.save();
    }
}
