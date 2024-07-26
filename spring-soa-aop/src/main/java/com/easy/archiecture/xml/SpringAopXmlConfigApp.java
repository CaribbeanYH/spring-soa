package com.easy.archiecture.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class SpringAopXmlConfigApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-config.xml");
        EasyArchiectureAOP easyArchiectureAOP = (EasyArchiectureAOP) context.getBean("easyArchiectureAOP");
        easyArchiectureAOP.getAopDesc();
        easyArchiectureAOP.getAopName();
//        easyArchiectureAOP.printThrowException();
    }
}
