package com.wzj.service.impl;

import com.wzj.domain.Account;
import com.wzj.mapper.AccountMapper;
import com.wzj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceimpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void save(Account account) {
      accountMapper.save(account);
    }

    @Override
    public List<Account> findAll() {
     return accountMapper.findAll();

    }
}
