package com.easy.architecture.annotation;

import com.easy.architecture.annotation.interfaces.HeroService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanghai10
 * @ClassName SpringAnnotationIocApp
 * @Description Spring注解启动容器
 * @date 2023/12/21 15:00
 */
public class SpringAnnotationIocApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation-root.xml");
//        Equipment bean = applicationContext.getBean(Equipment.class);
//        System.out.println(bean);
        HeroService heroService = applicationContext.getBean(HeroService.class);
        try {
            Object o = heroService.queryHero(1L);
            System.out.println(o);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
