package com.dao;

import com.models.Lector;
import com.models.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentdDAO {
    private Connection connection;

    public StudentdDAO() throws ClassNotFoundException, IOException, SQLException {
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

    public Student findLector(String log, String pass) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * " +
                        "FROM STUDENT " +
                        "WHERE LOG = ? " +
                        "      AND PASS = ?");

        preparedStatement.setString(1, log);
        preparedStatement.setString(2, pass);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        Student student = new Student(result.getInt(1), result.getString(2),
                result.getString(3), result.getString(4), result.getString(5),
                result.getString(6));
        return student;
    }

    public List<String> getResultTest(int idStudent) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT CONCAT(TEST.NAME, ' ', TEST_STUD.MARK) AS RESULT " +
                        "FROM " +
                        "  STUDENT, TEST_STUD, TEST " +
                        "WHERE STUDENT.ID = TEST_STUD.ID_STUD " +
                        "      AND TEST_STUD.ID_TEST = TEST.ID " +
                        "      AND STUDENT.ID = ? " +
                        "AND TEST_STUD.MARK IS NOT NULL");

        preparedStatement.setInt(1, idStudent);
        ResultSet result = preparedStatement.executeQuery();
        List<String> resultList = new ArrayList<String>();

        while (result.next()) {
            resultList.add(result.getString(1));
        }

        return resultList;
    }
}
