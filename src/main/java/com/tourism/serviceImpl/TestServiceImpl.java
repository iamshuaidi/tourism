package com.tourism.serviceImpl;

import com.tourism.dao.AdminMapper;
import com.tourism.model.Admin;
import com.tourism.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    AdminMapper adminMapper;


    public void addAdmin(Admin admin){
        adminMapper.insert(admin);

    }
}
