package com.tourism.model;

import org.springframework.stereotype.Component;

/**
 * 用来记录用户的一些信息
 */
@Component
public class HostHolder {
    private static ThreadLocal<Admin> admins = new ThreadLocal<Admin>();

    public Admin getAdmain() {
        return admins.get();
    }

    public void setUser(Admin admin) {
        admins.set(admin);
    }

    public void clear() {
        admins.remove();;
    }
}
