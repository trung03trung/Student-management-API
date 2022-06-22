package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentDAO;
import com.example.studentmanagement.repository.StudentDAOImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO=new StudentDAOImpl();
    public List<Student> getListStudent(){
        return studentDAO.getAll();
    }
    public Student findID(int id){
        return studentDAO.getOneById(id);
    }
    public boolean addNewStudent(Student student){
        return studentDAO.save(student);
    }

    public boolean deleteStudent(int id){
        return studentDAO.delete(id);
    }

    public List<Student> searchStudentByName(String name){
        name=name.toLowerCase();
        return studentDAO.getAllStudentByName(name);
    }

    public List<Student> searchStudentByDate(int start,int end){
        return studentDAO.getAllStudentByDate(start,end);
    }

    public List<Student> searchStudentByGender(String gender){
        gender=gender.toLowerCase();
        return studentDAO.getAllByGender(gender);
    }

    public List<Student> searchStudentByClassName(String cname){
        cname=cname.toLowerCase();
        return studentDAO.getAllByClassName(cname);
    }
    public List<Student> searchStudentByMajor(String major){
        major=major.toLowerCase();
        return studentDAO.getAllByMajor(major);
    }



    public List<Student> searchStudentByMark(float markBegin,float markEnd){

       return studentDAO.getAllByMark(markBegin,markEnd);

    }

    public List<Student> getListStudentSameDateToday(){
        return studentDAO.getAllByBirthday();
    }

}
