package com.tourism.service;

import com.tourism.model.Cookie;

public interface CookieService {

    void addCookie(int adminId);

    void updateCookie(Cookie cookie);

    Cookie findByAdminId(int id);

    Cookie findByCookie(String cookie);
}
