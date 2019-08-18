package com.tourism.service;

import com.tourism.model.Admin;

import java.util.Map;

public interface AdminService {

    Map<String, Object> login(String phone, String password);

    Map<String, Object> logout(String cookie);

    Admin findByPhone(String phone);

    Admin findById(int id);


}
