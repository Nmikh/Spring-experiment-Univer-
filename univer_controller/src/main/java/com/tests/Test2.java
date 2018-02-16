package com.tests;

import com.controllers.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-app.xml");
        StudentController controller = context.getBean("studentController", StudentController.class);
        controller.authorized("ccc","ccc");
        controller.getResults();
    }
}
