package com.hou.dao;

import com.hou.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudent();

    Student getStudentById(@Param("id") Integer id);

    Student getStudentById1(@Param("id") Integer id);
}
