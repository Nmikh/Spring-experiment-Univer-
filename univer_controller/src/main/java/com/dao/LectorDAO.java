package com.dao;

import com.models.Lector;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LectorDAO {

    private Connection connection;

    public LectorDAO() throws ClassNotFoundException, SQLException, IOException {
        InputStream resourceAsStream =
                Properties.class.getResourceAsStream("/db/db.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);

        LectorDAO.class.getClass().forName("org.h2.Driver");
        connection = DriverManager.getConnection(
                (String) properties.get("url"),
                (String) properties.get("login"),
                (String) properties.get("password"));
    }

    public Lector findLector(String log, String pass) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * " +
                        "FROM LECTOR " +
                        "WHERE LOG = ? " +
                        "      AND PASS = ?");

        preparedStatement.setString(1, log);
        preparedStatement.setString(2, pass);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        Lector lector = new Lector(result.getInt(1), result.getString(2),
                result.getString(3), result.getString(4), result.getString(5),
                result.getString(6));
        return lector;
    }

    public List<String> getResultTest(int idTest) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT CONCAT(STUDENT.NAME,' ',STUDENT.SURNAME,' ', TEST_STUD.MARK) AS RESULTS " +
                        "FROM TEST, TEST_STUD, STUDENT " +
                        "WHERE TEST_STUD.ID_TEST = TEST.ID " +
                        "AND TEST_STUD.ID_STUD = STUDENT.ID " +
                        "AND TEST.ID = ?");

        preparedStatement.setInt(1, idTest);
        ResultSet result = preparedStatement.executeQuery();
        List<String> resultList = new ArrayList<String>();

        while (result.next()) {
            resultList.add(result.getString(1));
        }

        return resultList;
    }

    public void addTestToStudent(int idTest, int idStud) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert Into TEST_STUD (ID_STUD , ID_TEST) " +
                        "VALUES (?,?)");
        preparedStatement.setInt(2, idTest);
        preparedStatement.setInt(1, idStud);
    }

    public List<Integer> findStudentByGroup(String group) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT ID" +
                        "FROM STUDENT " +
                        "WHERE \"Group\" = ? ");

        preparedStatement.setString(1, group);
        ResultSet result = preparedStatement.executeQuery();
        List<Integer> studentsId = new ArrayList<Integer>();
        while (result.next()) {
            studentsId.add(result.getInt(1));
        }
        return studentsId;
    }

    public  void addMarkToStudent(int idTest, int idStudent, int mark) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE TEST_STUD " +
                        "SET MARK = ? " +
                        "WHERE ID_STUD = ? " +
                        "AND ID_TEST = ?");
        preparedStatement.setInt(1, mark);
        preparedStatement.setInt(2, idStudent);
        preparedStatement.setInt(3, idTest);

    }
}

