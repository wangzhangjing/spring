package com.wzj.mapper;

import com.wzj.domain.Account;

import java.util.List;

public interface AccountMapper {

    public void save(Account account);


    public List<Account>findAll();
}
