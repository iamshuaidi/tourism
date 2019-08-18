package com.tourism.interceptor;

import com.tourism.model.Admin;
import com.tourism.model.HostHolder;
import com.tourism.service.LoginService;
import com.tourism.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by nowcoder on 2016/7/3.
 */
@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    private CookieService cookieService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ticket = null;
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {

                if (cookie.getName().equals("cookie")) {
                    System.out.println("cookie = " + cookie.getValue());
                    ticket = cookie.getValue();
                    break;
                }
            }
        }

        if (ticket != null) {
            com.tourism.model.Cookie cookie = cookieService.findByCookie(ticket);
            System.out.println("loginTicket = " + cookie);
            if (cookie == null || cookie.getValidTime().before(new Date()) || cookie.getCookieStatus() != 0) {
                return true;
            }

            Admin admin = loginService.findById(cookie.getAdminId());
            hostHolder.setUser(admin);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
       // if (modelAndView != null && hostHolder.getUser() != null) {
         //   modelAndView.addObject("user", hostHolder.getUser());
       // }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        hostHolder.clear();
    }
}
