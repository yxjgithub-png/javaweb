package com.yaoxinjia.repository;

import com.yaoxinjia.entity.Admin;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 下午 7:41
 */
public interface AdminRepository {
    public Admin login(String username, String password);
}
