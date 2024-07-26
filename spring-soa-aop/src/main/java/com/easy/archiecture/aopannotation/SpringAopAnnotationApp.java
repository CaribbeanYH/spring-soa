package com.easy.archiecture.aopannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class SpringAopAnnotationApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        EasyArchiecture easyArchiecture = context.getBean("easyArchiecture", EasyArchiecture.class);
        easyArchiecture.print();
        easyArchiecture.calculate();
    }
}
