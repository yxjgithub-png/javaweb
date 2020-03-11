package com.yaoxinjia.repository;

import com.yaoxinjia.entity.Reader;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 上午 11:23
 */
public interface ReaderRepository {
    public Reader login(String uername, String password);
}
