package com.hou.dao;

import com.hou.pogo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//get
    List<User> getUserLike(String value);

    //查询全部用户00000000
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //插入用户
    void addUser(User user);

    void addUserByParam(@Param("id") int id,@Param("name") String name, @Param("password") String pwd);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    int addUser2(Map<String, Object> map);

    User getUserById2(Map<String, Object> map);

    void batchUpdateUser(Map<String,Object> map);
}
