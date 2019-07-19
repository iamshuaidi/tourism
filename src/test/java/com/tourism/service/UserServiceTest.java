package com.tourism.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void login() {
        Map<String, Object> map = userService.login("123","12");
        if (map.containsKey("msg")) {
            System.out.println(map.get("msg"));
            return;
        }

        System.out.println(map.get("user"));
    }
}