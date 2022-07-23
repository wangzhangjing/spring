package com.wzj.domain;

import java.util.Date;
import java.util.List;

public class User1 {
    private int id;
    private String username;
    private String password;
    private Date birthday;

  //当前用户有哪些角色
private List<Role>roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
//当前用户具有的订单
//    public List<Order1> getOrder1List() {
//        return order1List;
//    }
//
//    public void setOrder1List(List<Order1> order1List) {
//        this.order1List = order1List;
//    }
//
//    private List<Order1>order1List;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", roleList=" + roleList +
                '}';
    }
}
