package com.tourism.serviceImpl;

import com.tourism.dao.CookieMapper;
import com.tourism.model.Cookie;
import com.tourism.model.CookieExample;
import com.tourism.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CookieServiceImpl implements CookieService {
    @Autowired
    CookieMapper cookieMapper;
    @Override
    public void addCookie(int adminId) {

        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
      //  ticket.setExpired(date);
       // ticket.setStatus(0);

        Cookie cookie = new Cookie();
        cookie.setAdminId(adminId);
        cookie.setCookie(UUID.randomUUID().toString());
        cookie.setLoginTime(new Date());
        cookie.setValidTime(date);
        Integer status = 0;
        // 暂时就用字节流了
        cookie.setCookieStatus(status.byteValue());
        cookieMapper.insert(cookie);
    }

    @Override
    public void updateCookie(Cookie cookie) {
        cookieMapper.updateByPrimaryKey(cookie);
    }

    @Override
    public Cookie findByAdminId(int adminId) {
        CookieExample example = new CookieExample();
        CookieExample.Criteria criteria = example.createCriteria();
        criteria.andAdminIdEqualTo(adminId);

        List<Cookie> cookies = cookieMapper.selectByExample(example);
        if(cookies == null || cookies.size() < 1)
            return null;

        return cookies.get(0);

    }

    @Override
    public Cookie findByCookie(String cookie) {
        CookieExample example = new CookieExample();
        CookieExample.Criteria criteria = example.createCriteria();
        criteria.andCookieEqualTo(cookie);

        List<Cookie> cookies = cookieMapper.selectByExample(example);
        return cookies.get(0);
    }
}
