package com.controllers;

import com.models.Student;
import com.services.StudentService;

public class StudentController {
    private Student student;

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void authorized(String log, String pass) {
        if (studentService.findStudentByLogPass(log, pass) != null) {
            student = studentService.findStudentByLogPass(log, pass);
            System.out.println(student);
        }
    }

    public void getResults() {
        if (studentService.getResults(student.getId()) != null) {
            System.out.println(studentService.getResults(student.getId()));
        }
    }

    public void getNoMarkedTests() {//todo
    }
}
