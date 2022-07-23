package com.wzj.service.impl;

import com.wzj.dao.UserDao;
import com.wzj.service.UserService;

public class UserServiceimpl implements UserService {

    private UserDao  userDao;

    public void setUserDao(UserDao userDao) { this.userDao = userDao; }

    public void qq() {
        userDao.wzj();
    }
}
