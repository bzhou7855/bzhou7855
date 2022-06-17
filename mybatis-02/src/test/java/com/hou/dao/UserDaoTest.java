package com.hou.dao;

import com.hou.pogo.User;
import com.hou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
//            List<User> userList = userDao.getUserList();

            // method 2
        List<User> userList = sqlSession.selectList("com.hou.dao.UserMapper.getUserList");

        userList.forEach((u)-> System.out.println(u));

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }

    }

}
