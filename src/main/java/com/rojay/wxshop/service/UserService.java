package com.rojay.wxshop.service;

import com.rojay.wxshop.UserDao;
import com.rojay.wxshop.generate.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年12月01日  16:35:44
 */
@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUserIfNotExist(String tel) {
        User user = new User();
        user.setTel(tel);
        user.setCreatedAt(new Date());
        user.setUpdateAt(new Date());
        userDao.insertUser(user);
        return user;
    }
}
