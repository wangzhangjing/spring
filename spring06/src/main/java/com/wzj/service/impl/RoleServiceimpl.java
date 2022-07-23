package com.wzj.service.impl;

import com.wzj.dao.RoleDao;
import com.wzj.domain.Role;
import com.wzj.service.RoleService;

import java.util.List;

public class RoleServiceimpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
