package com.tourism.model;

import java.util.Date;

public class Cookie {
    private Integer id;

    private String cookie;

    private Byte cookieStatus;

    private Date loginTime;

    private Date validTime;

    private Integer adminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    public Byte getCookieStatus() {
        return cookieStatus;
    }

    public void setCookieStatus(Byte cookieStatus) {
        this.cookieStatus = cookieStatus;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}