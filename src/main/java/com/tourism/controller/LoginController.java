package com.tourism.controller;


import com.alibaba.fastjson.JSONObject;
import com.tourism.model.Admin;
import com.tourism.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;



    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(Admin admin) {

        Map<String, Object> map = new HashMap<>();
        map = adminService.login(admin.getPhone(), admin.getPwd());

        return JSONObject.toJSONString(map);

    }



    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(@CookieValue("cookie") String cookie) {

        return "";
    }
}
