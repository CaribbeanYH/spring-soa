package com.easy.archiecture.oldaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOldAopMain {

    public static void main(String[] args) {
        testAdvice();
//        testAdvisor();
//        testAutoProxy();
    }

    public static void testAdvice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("oldaop_advice.xml");
        // 我们这里要取 AOP 代理：userServiceProxy，这非常重要
        UserService userService = (UserService) context.getBean("userServiceProxy");

        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
    }

    public static void testAdvisor(){
        // 启动 Spring 的 IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("oldaop_advisor.xml");

        // 我们这里要取 AOP 代理：userServiceProxy，这非常重要
        UserService userService = (UserService) context.getBean("userServiceProxy");

        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
    }

    public static void testAutoProxy(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("oldaop_autoproxy.xml");
        UserService bean = context.getBean(UserService.class);
        bean.createUser("Tom", "Cruise", 55);
        bean.queryUser();
    }
}
