package com.hou.dao;

import com.hou.pogo.User;
import com.hou.utils.MybatisUtils;
import com.sun.media.sound.SoftTuning;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            //User user = userDao.getUserById(8);

            //System.out.println(user);

            List<User> userList = userDao.getUser();
            userList.forEach(u-> System.out.println(u));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }
}
