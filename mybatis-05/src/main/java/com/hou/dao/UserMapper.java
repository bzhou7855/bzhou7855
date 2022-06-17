package com.hou.dao;

import com.hou.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from USER")
    List<User> getUsers();

    //方法存在多个参数，所有的参数必须加@Param
    @Select("select * from USER where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into USER (id, name, pwd) values" +
            "(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update USER set name=#{name}, pwd=#{password} " +
            "where id=#{id}")
    int updateUser(User user);

    @Delete("delete from USER where id=#{id}")
    int deleteUser(@Param("id") int id);

}
