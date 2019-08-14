package com.tourism.serviceImpl;

import com.tourism.dao.AdminMapper;
import com.tourism.model.Admin;
import com.tourism.model.AdminExample;
import com.tourism.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Map<String, Object> login(String phone, String password) {
        Map<String, Object> map = new HashMap<>();

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        if(adminMapper == null){
            System.out.println("注入失败");
            return map;
        }

        List<Admin> list = adminMapper.selectByExample(example);
        if(list == null || list.size() <= 0){
            map.put("message", "改用户不存在");
            return map;
        }
        Admin admin = list.get(0);
        if(!admin.getPwd().equals(password)){
            map.put("message", "用户密码错误");
            return map;
        }

        map.put("admin", admin);
        map.put("message", "OK");
        return map;
    }

    @Override
    public Map<String, Object> logout(String coolie) {
        return null;
    }


    @Override
    public Admin findByPhone(String phone) {

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        if(adminMapper == null){
            System.out.println("注入失败5555");
        }
        List<Admin> list = adminMapper.selectByExample(example);
        return list.get(0);
    }
}
