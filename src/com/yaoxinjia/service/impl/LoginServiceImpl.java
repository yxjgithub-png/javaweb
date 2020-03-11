package com.yaoxinjia.service.impl;

import com.yaoxinjia.repository.AdminRepository;
import com.yaoxinjia.repository.ReaderRepository;
import com.yaoxinjia.repository.impl.AdminRepositoryImpl;
import com.yaoxinjia.repository.impl.ReaderReposityimpl;
import com.yaoxinjia.service.LoginService;

/**
 * @author shkstart
 * @date 2020/2/17 0017 - 上午 11:19
 */
public class LoginServiceImpl implements LoginService {
    private ReaderRepository readerRepository = new ReaderReposityimpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();
    @Override
    public Object login(String username, String password,String type) {
        Object object = null;
        switch (type){
            case "reader":
                object =  readerRepository.login(username,password);
                break;

            case "admin":
                object =  adminRepository.login(username,password);
                break;
        }
        return object;
    }
}


