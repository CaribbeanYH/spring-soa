package com.easy.architecture.staticfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("staticFactoryBean.xml");
        Chinese chinese = (Chinese) applicationContext.getBean("chinese", Person.class);
        chinese.say();
        American american = (American) applicationContext.getBean("american", Person.class);
        american.say();

    }
}
