package com.tourism.serviceImpl;

import com.tourism.dao.*;
import com.tourism.model.*;
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
