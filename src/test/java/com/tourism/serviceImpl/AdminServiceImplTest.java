package com.tourism.serviceImpl;

import com.tourism.model.Admin;
import com.tourism.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration(classes = TourismApplication.class)
@SpringBootTest
@SpringBootConfiguration
@SpringBootApplication(scanBasePackages={"com.tourism.service",
        "com.tourism.controller", "com.tourism.serviceImpl"})
@MapperScan("com.tourism.dao")
public class AdminServiceImplTest {

   // @Autowired
    //AdminService adminService;

    @Test
    public void testLogin(){
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.findByPhone("123");
        System.out.println(admin);
    }

}