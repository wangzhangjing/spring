package com.wzj.dao;

import com.wzj.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;
    public User findid(int id);
    public List<User>findids(List<Integer> ids);
}
