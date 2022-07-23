package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.Userdaolmpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new Userdaolmpl();
    }
}
