package com.easy.architecture.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanghai10
 * @ClassName SpringAnnotationIocApp
 * @Description Spring注解启动容器
 * @date 2023/12/21 15:00
 */
public class SpringAnnotationIocApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-xml-config.xml");
        HeroCaoCao heroCaoCao = (HeroCaoCao) applicationContext.getBean("heroCaoCao");
        heroCaoCao.ability();
//        heroCaoCao.input();
//        HeroCaoCao heroCaoCao1 = (HeroCaoCao) applicationContext.getBean("heroCaoCao");
//        System.out.println(heroCaoCao == heroCaoCao1);
//        HeroCaoCao p1=new HeroCaoCao();
//        p1.setName("aaaaa");
//        p1.input();
//        Class<?> clazz = Class.forName("com.easy.com.easy.archiecture.constructor.HeroCaoCao");
//        Object o = clazz.newInstance();
    }
}
