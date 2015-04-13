package com.xinux.testDemo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinux.test.model.User;
import com.xinux.test.service.UserService;

public class UserTest {

    public UserService userService;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
                "classpath:config/spring.xml", "classpath:config/spring-mybatis.xml" });
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void testfindUserById() {
        int userId = 1;
        User user = userService.getUserById(userId);
        System.out.println("find User By Id Successed!");
        assertEquals("Xinux", user.getUserName());
    }
}
