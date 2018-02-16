package com.tests;

import com.controllers.LectorController;
import com.dao.LectorDAO;
import com.models.Lector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-app.xml");
        LectorController controller = context.getBean("lectorController", LectorController.class);
        controller.authorized("aaa", "aaa");
        controller.getResultsForTest(1);
        controller.getResultsForTest(2);

    }
}
