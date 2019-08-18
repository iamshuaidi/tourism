package com.tourism.controller;


import com.alibaba.fastjson.JSONObject;
import com.tourism.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;



    @CrossOrigin
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody

    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password,
                        HttpServletResponse response) {

        Map<String, Object> map =  loginService.login(phone, password);
        if(!map.containsKey("cookie")){
            return JSONObject.toJSONString(map);
        }
        // 如果登录成功
        Cookie cookie = new Cookie("cookie", map.get("cookie").toString());
        cookie.setPath("/");
        cookie.setMaxAge(3600*24*5);
        response.addCookie(cookie);



        return JSONObject.toJSONString(map);

    }


    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(@CookieValue("cookie") String cookie) {
        Map<String, Object> map = loginService.logout(cookie);
        return JSONObject.toJSONString(map);
    }
}
