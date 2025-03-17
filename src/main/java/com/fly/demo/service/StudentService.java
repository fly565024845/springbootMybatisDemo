package com.fly.demo.service;

import com.fly.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryAll();

    Student getStudent(Integer id);

    int delete(Integer id);

    int update(Student student);

    int insert(Student student);

}
