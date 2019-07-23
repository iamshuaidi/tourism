package com.tourism.controller;

import com.tourism.model.Admin;
import com.tourism.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("username") String username,
                           @RequestParam("password")String password, @RequestParam("phone")String phone){
       Admin admin = new Admin();
       admin.setName(username);
       admin.setSalt(UUID.randomUUID().toString().substring(0, 10));
       admin.setPwd(password + admin.getSalt());
       admin.setPhone(phone);
       testService.addAdmin(admin);
        //注册成功跳转到个人中心
        return "home";
    }

    @RequestMapping("/index")
    public String index(){
        return "register";
    }


}
