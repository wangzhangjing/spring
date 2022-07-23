package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.Userdaolmpl;

public class StaticFactory {

    public static UserDao getUserDao(){
        return new Userdaolmpl();
    }
}
