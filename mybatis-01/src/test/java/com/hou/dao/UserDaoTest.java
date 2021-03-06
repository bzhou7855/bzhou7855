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
/////////
        try{
            // 1.执行 getmapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();

            // method 2
//        List<User> userList = sqlSession.selectList("com.hou.dao.UserDao.getUserList");

//            for(User user: userList){
//                System.out.println(user);
//            }
            userList.forEach(System.out::println);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUserByParam(8,"test1","87654321");
        //mapper.addUser(new User(5,"hou","123456"));

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"hou","123"));

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void updateUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("defaultPwd","888888");
        mapper.batchUpdateUser(map);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(2);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id1",9);
        map.put("name1","test9");
        map.put("pwd1","123456");
        mapper.addUser2(map);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("helloid",5);
        map.put("name","test5");
        User user = mapper.getUserById2(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserLike("test");

        list.forEach(u->System.out.println(u.getName()));

        sqlSession.close();

        String json = "{\"name\": \"wanghang\",\"age\": 12,\"country\": \"china\"}\n";

    }


    @Test
    public void test1test()
    {
        System.out.println("=================");
    }


}
