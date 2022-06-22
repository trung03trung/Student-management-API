package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/student")
public class StudentController {
     StudentService studentService=new StudentService();



    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent(){
        return studentService.getListStudent();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewStudent(Student student){
        return studentService.addNewStudent(student)?"Thêm mới thành công":"Thêm mới thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteStudent(@PathParam("id") int id){
        return studentService.deleteStudent(id)?"Xóa thành công":"Xóa thất bại";
    }

    @GET
    @Path("/name-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByName(@QueryParam("name") String name){
        return studentService.searchStudentByName(name);
    }

    @GET
    @Path("/date-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByDate(@QueryParam("start") int start,@QueryParam("end") int end){
        return studentService.searchStudentByDate(start,end);
    }

    @GET
    @Path("/gender-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByGender(@QueryParam("gender") String gender){
        return studentService.searchStudentByGender(gender);
    }

    @GET
    @Path("/class-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByClassName(@QueryParam("class") String className){
        return studentService.searchStudentByClassName(className);
    }

    @GET
    @Path("/major-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByMajor(@QueryParam("major") String major){
        return studentService.searchStudentByMajor(major);
    }

    @GET
    @Path("/mark-query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByMark(@QueryParam("start") int markBegin,@QueryParam("end") int markEnd){
        return studentService.searchStudentByMark(markBegin,markEnd);
    }

    @GET
    @Path("/birthday")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentSameDateToday(){
        return studentService.getListStudentSameDateToday();
    }



}
