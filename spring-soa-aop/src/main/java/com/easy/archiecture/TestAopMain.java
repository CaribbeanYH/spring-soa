package com.easy.archiecture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopMain {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringAopTest.xml");
        com.easy.archiecture.springaop.Student student = (com.easy.archiecture.springaop.Student) context.getBean("student");
        student.getName();
        student.getAge();
        student.printThrowException();
    }
}
