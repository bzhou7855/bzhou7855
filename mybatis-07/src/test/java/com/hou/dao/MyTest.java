package com.hou.dao;

import com.hou.pojo.Student;
import com.hou.pojo.Teacher;
import com.hou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
//            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//
//            Teacher teacher = teacherMapper.getSingleTeacher(1);
//            System.out.println(teacher);

//            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//            Teacher teacher = teacherMapper.getTeacherAndStudent(1);
//            //students.forEach(System.out::println);
//            System.out.println(teacher);

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student studentById1 = studentMapper.getStudentById1(1);
            System.out.println(studentById1);



//            Teacher(id=1, name=hou,
//            studentList=[
//            Student(id=1, name=xiao1, tid=0),
//            Student(id=2, name=xiao2, tid=0),
//            Student(id=3, name=xiao3, tid=0),
//            Student(id=4, name=xiao4, tid=0),
//            Student(id=5, name=xiao5, tid=0)])

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("total use:"+(end-start)+"毫秒");
    }

}
