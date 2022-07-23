package com.wzj.mapper;

import com.wzj.domain.Order1;
import com.wzj.domain.User1;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper1 {
    @Select("SELECT * FROM orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property ="user",//要封装的属性名称
                    column ="uid",//根据那个字段去查询user数据表
                    javaType =User1.class,//要封装的实体类型
                    //select属性 代表查询那个接口的获得方法
                    one = @One(select ="com.wzj.mapper.UserMapper1.findid")
            )

    })
//    @Select("SELECT *,o.id oid FROM orders o,USER u WHERE o.uid=u.id")
//    @Results({
//            @Result(column = "oid",property = "id"),
//            @Result(column = "ordertime",property = "ordertime"),
//            @Result(column = "total",property = "total"),
//            @Result(column = "uid",property = "user.id"),
//            @Result(column = "username",property = "user.username"),
//            @Result(column = "password",property = "user.password")
//    })
    public List<Order1>findAlll();

    @Select("SELECT * FROM orders WHERE uid=#{uid}")
    public List<Order1> findbyuid(int i);
}
