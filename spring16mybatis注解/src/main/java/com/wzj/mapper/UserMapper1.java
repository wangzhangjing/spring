package com.wzj.mapper;

import com.wzj.domain.User1;
import org.apache.ibatis.annotations.*;

import java.util.List;
//
//@SuppressWarnings("MybatisXMapperMethodInspection")
public interface UserMapper1{
@Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User1 user);

@Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void updata(User1 user);

@Delete("delect from user where id=#{id}")
    public void delete(int id);

@Select("select * from user where id=#{id}")
    public User1 findid(int id);

@Select("select * from user")
    public List<User1> findAll();
@Select("select * from user")
@Results({
        @Result(id = true ,column = "id",property = "id"),
        @Result(column = "username",property = "username"),
        @Result(column = "password",property = "password"),
        @Result(
                property = "order1List",
                column = "id",
                javaType = List.class,
                many = @Many(select ="com.wzj.mapper.OrderMapper1.findbyuid")
        )}


)
public List<User1>finduserandorderall();
     @Select("select * from user")
     @Results({
             @Result(id = true ,column = "id",property = "id"),
             @Result(column = "username",property = "username"),
             @Result(column = "password",property = "password"),
             @Result(
                     property = "RoleList",
                     column = "id",
                     javaType = List.class,
                     many = @Many(select ="com.wzj.mapper.OrderMapper1.findbyuid")
             )})
     public List<User1>findUser1andRoleAll();

}
