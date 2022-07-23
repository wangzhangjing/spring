package com.wzj.test;

import com.wzj.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class JdbcTemplateCRUDText {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void textUpdate(){
        jdbcTemplate.update("update account set money=? where name =?",12234,"tom");
    }
    @Test
    public void textDelete(){
        jdbcTemplate.update("delete from account where name =?","tom");
    }
    @Test
    public void textQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
    @Test
    public void textQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),"tom");

        System.out.println(account);
    }
    @Test
    public void textQueryCount(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }
}
