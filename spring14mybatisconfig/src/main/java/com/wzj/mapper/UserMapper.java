package com.wzj.mapper;

import com.wzj.domain.User;

import java.util.List;

public interface UserMapper {
      public void save(User user);
      public User findid(int id);
      public List<User> findAll();
}
