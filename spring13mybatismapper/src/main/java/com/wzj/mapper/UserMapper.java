package com.wzj.mapper;

import com.wzj.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> fand(User user);
    public List<User>findids(List<Integer> ids);
}
