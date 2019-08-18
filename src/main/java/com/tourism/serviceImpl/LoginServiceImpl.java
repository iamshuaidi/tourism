package com.tourism.serviceImpl;

import com.tourism.dao.AdminMapper;
import com.tourism.model.Admin;
import com.tourism.model.AdminExample;
import com.tourism.model.Cookie;
import com.tourism.service.LoginService;
import com.tourism.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    CookieService cookieService;

    @Override
    public Map<String, Object> login(String phone, String password) {
        Map<String, Object> map = new HashMap<>();

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);

        List<Admin> list = adminMapper.selectByExample(example);
        if(list == null || list.size() <= 0){
            map.put("message", "该用户不存在");
            return map;
        }
        Admin admin = list.get(0);
        if(!admin.getPwd().equals(password)){
            map.put("message", "用户密码错误");
            return map;
        }

        Cookie cookie = cookieService.findByAdminId(admin.getId());
        if(cookie == null){
            cookieService.addCookie(admin.getId());
        }else{

            cookie.setCookieStatus(((Integer)0).byteValue());
            cookie.setCookie(UUID.randomUUID().toString());
            Date date = new Date();
            date.setTime(date.getTime() + 1000 * 24 * 3600);
            cookie.setValidTime(date);
            cookie.setLoginTime(new Date());

            cookieService.updateCookie(cookie);
        }

        map.put("cookie", cookie.getCookie());
        map.put("admin", admin);
        map.put("message", "OK");
        //map.put("message", "OK");
        return map;
    }

    @Override
    public Map<String, Object> logout(String cookie) {
        Map<String, Object> map = new HashMap<>();
        Cookie cookie1 = cookieService.findByCookie(cookie);
        cookie1.setCookieStatus(((Integer)1).byteValue());
        cookieService.updateCookie(cookie1);

        map.put("message", "OK");
        return map;
    }


    @Override
    public Admin findByPhone(String phone) {

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);

        List<Admin> list = adminMapper.selectByExample(example);
        return list.get(0);
    }

    @Override
    public Admin findById(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
