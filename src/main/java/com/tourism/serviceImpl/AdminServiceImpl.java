package com.tourism.serviceImpl;

import com.tourism.dao.AdminMapper;
import com.tourism.model.Admin;
import com.tourism.model.AdminExample;
import com.tourism.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin showAdminInfo(Admin admin){
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andIdEqualTo(admin.getId());
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        return adminList.get(0);
    }

}
