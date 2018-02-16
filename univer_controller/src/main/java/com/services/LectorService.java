package com.services;

import com.dao.LectorDAO;
import com.models.Lector;

import java.sql.SQLException;
import java.util.List;

public class LectorService {
    private LectorDAO lectorDAO;

    public void setLectorDAO(LectorDAO lectorDAO) {
        this.lectorDAO = lectorDAO;
    }

    public LectorDAO getLectorDAO() {
        return lectorDAO;
    }

    public Lector findLectorByLogPass(String log, String pass) {
        try {
            return lectorDAO.findLector(log, pass);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<String> createDocumentResultByTest(int idTest) {
        try {
            return lectorDAO.getResultTest(idTest);
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean addTestToGroup(String group, int idTest) {
        try {
            List<Integer> studentsId = lectorDAO.findStudentByGroup(group);
            for (int i : studentsId) {
                lectorDAO.addTestToStudent(idTest, i);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean addMarkToStudent(int idTest, int idStudent, int mark){
        try {
            lectorDAO.addMarkToStudent(idTest, idStudent, mark);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
