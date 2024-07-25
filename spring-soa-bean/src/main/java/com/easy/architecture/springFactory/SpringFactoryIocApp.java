package com.easy.architecture.springFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class SpringFactoryIocApp {
    public static void main(String[] args) {

        //FactoryBean是动态注入Bean
        //BeanFactory主要是负责Bean实例化、定位、配置应用程序中的对象及建立这些对象间的依赖
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");
        YuJi yuJi = (YuJi) applicationContext.getBean("yuJi", Hero.class);
        yuJi.ability();
        LvBu lvBu = (LvBu) applicationContext.getBean("lvBu", Hero.class);
        lvBu.ability();
    }
}
