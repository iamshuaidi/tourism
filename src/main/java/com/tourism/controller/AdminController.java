package com.tourism.controller;

import com.tourism.model.Admin;
import com.tourism.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    AdminService adminService;

    //进入管理员中心
    @CrossOrigin
    @RequestMapping(path = "/adminHome", method = RequestMethod.POST)
    @ResponseBody
    public Admin showAdminInfo(Model model, @RequestParam("id") Integer id,
                          @RequestParam("name")String name, @RequestParam("nickname")String nickname,
                          @RequestParam("pwd")String pwd, @RequestParam("salt")String salt,
                          @RequestParam("phone")String phone, @RequestParam("idNum")Integer idNum,
                          @RequestParam("avatarUrl")String avatarUrl){
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setNickname(nickname);
        admin.setPwd(pwd);
        admin.setSalt(salt);
        admin.setPhone(phone);
        admin.setIdNum(idNum);
        admin.setAvatarUrl(avatarUrl);
        adminService.showAdminInfo(admin);
//        return "home";
        return admin;
    }

    @CrossOrigin
    @RequestMapping(path = "/editAdminInfo", method = RequestMethod.POST)
    @ResponseBody
    public Admin editAdminInfo(Model model, @RequestParam("id") Integer id,
                               @RequestParam("name")String name, @RequestParam("nickname")String nickname,
                               @RequestParam("pwd")String pwd, @RequestParam("salt")String salt,
                               @RequestParam("phone")String phone, @RequestParam("idNum")Integer idNum,
                               @RequestParam("avatarUrl")String avatarUrl){
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setNickname(nickname);
        admin.setPwd(pwd);
        admin.setSalt(salt);
        admin.setPhone(phone);
        admin.setIdNum(idNum);
        admin.setAvatarUrl(avatarUrl);
        adminService.editAdminInfo(admin);
//        return "home";
        return admin;
    }

}
