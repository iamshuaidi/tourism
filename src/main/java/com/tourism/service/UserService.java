package com.tourism.service;

import com.tourism.dao.UserDao;
import com.tourism.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public Map<String,Object> register(String name, String password, String phone) {
        Map<String, Object> map = new HashMap<>();
        if(name == null || name.length() < 1){
            map.put("msg", "用户名不能为空");
            return map;
        }
        if(password == null || password.length() < 1){
            map.put("msg", "密码不能为空");
            return map;
        }
        if (phone == null || phone.length() < 11) {
            map.put("msg", "手机号格式有误");
            return map;
        }
        User user = userDao.selectByName(name);
        if (user != null) {
            map.put("msg", "用户名已存在");
            return map;
        }
        user = userDao.selectByPhone(phone);
        if (user != null) {
            map.put("msg", "该手机号码已被注册");
            return map;
        }
        // 开始注册
        user = new User();
        user.setName(name);
        user.setSalt(UUID.randomUUID().toString().substring(0, 10));
        user.setPassword(password + user.getSalt());
        user.setPhone(phone);
        userDao.addUser(user);

        return map;
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = userDao.selectByName(username);
        if (user == null) {
            map.put("msg", "该用户不存在");
            return map;
        }
        password = password + user.getSalt();
        if (!password.equals(user.getPassword())) {
            map.put("msg", "密码错误");
            return map;
        }
        map.put("user", user);
        return map;
    }

    public User getUserByName(String name){
        return userDao.selectByName(name);
    }
}
