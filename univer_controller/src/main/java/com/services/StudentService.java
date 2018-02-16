package com.services;

import com.dao.StudentdDAO;
import com.models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentdDAO studentDAO;

    public void setStudentDAO(StudentdDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentdDAO getStudentDAO() {
        return studentDAO;
    }

    public Student findStudentByLogPass(String log, String pass) {
        try {
            return studentDAO.findLector(log, pass);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<String> getResults(int idStudent) {
        try {
            return studentDAO.getResultTest(idStudent);
        } catch (SQLException e) {
            return null;
        }
    }
}
