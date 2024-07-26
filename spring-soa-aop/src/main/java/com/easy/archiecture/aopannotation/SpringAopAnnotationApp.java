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
    /**
     * Advice: org.aopalliance.aop.Advice
     * “通知”，表示 Aspect 在特定的 Join point 采取的操作。包括 “around”, “before” and “after 等
     *
     * Pointcut: org.springframework.aop.Pointcut
     * “切点”，它是用来匹配连接点 Join point 的，可以说"Pointcut"表示的是"Join point"的集合。
     *
     * Advisor: org.springframework.aop.Advisor
     * “通知者”，它持有 Advice，是 Spring AOP 的一个基础接口。
     *
     * Advised: org.springframework.aop.framework.Advised
     * AOP 代理工厂配置类接口。提供了操作和管理 Advice 和 Advisor 的能力。
     */
}
