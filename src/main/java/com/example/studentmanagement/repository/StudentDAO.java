package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;

import java.util.List;

public interface StudentDAO  {
    List<Student> getAll();
    Student getOneById(int id);
    boolean save(Student s);

    boolean delete(int id);

    List<Student> getAllStudentByName(String name);
    List<Student> getAllStudentByDate(int start,int end);

    List<Student> getAllByGender(String gender);

    List<Student> getAllByClassName(String name);

    List<Student> getAllByMajor(String major);

    List<Student> getAllByMark(float markBegin,float markEnd);

    List<Student> getAllByBirthday();
}
