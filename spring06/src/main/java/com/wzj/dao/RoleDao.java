package com.wzj.dao;

import com.wzj.domain.Role;

import java.util.List;

public interface RoleDao {
      List<Role> findAll();

      void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
