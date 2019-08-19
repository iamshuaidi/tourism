package com.tourism.controller;


import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    /*
    @Autowired
    UserService userService;
     */

    /**
     *
     * @param model 用来填充视图数据
     * @param username 用户名
     * @param password 密码
     * @param phone 注册的手机号码
     * @return 返回一个 html 页面
     */

    /*
    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("username") String username,
                           @RequestParam("password")String password, @RequestParam("phone")String phone){
        Map<String, Object> map = userService.register(username, password, phone);
        if (map.containsKey("msg")) {
            model.addAttribute("msg", map.get("msg"));
            System.out.println("出错了");
            return "/register";
=======
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
>>>>>>> 6daba140f586197155b3ad628823fdd35af11a22
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
    }*/
}
