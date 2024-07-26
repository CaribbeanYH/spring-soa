package com.easy.archiecture.aspectjaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class SpringAspectAopXmlConfigApp {

    public static void main(String[] args) {
//        runAopAdvice();
//        runAopAdvisor();
        runAutoProxy();
    }

    //通知(Advice)
    public static void runAopAdvice() {
        ApplicationContext context = new ClassPathXmlApplicationContext("oldaop_advice.xml");
        // 我们这里要取 AOP 代理：creatorProxy，这非常重要
        ICreator ICreator = (ICreator) context.getBean("creatorProxy");
        ICreator.createEasyAOP("Tom", "Cruise", 55);
        ICreator.queryEasyAOP();
    }

    //Advisor(高级通知) = Advice(通知) + Pointcut(切入点)
    public static void runAopAdvisor() {
        // 启动 Spring 的 IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("oldaop_advisor.xml");
        // 我们这里要取 AOP 代理：creatorProxy，这非常重要
        ICreator ICreator = (ICreator) context.getBean("creatorProxy");
        ICreator.createEasyAOP("Tom", "Cruise", 55);
        ICreator.queryEasyAOP();
    }

    //AutoProxy
    public static void runAutoProxy() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("oldaop_autoproxy.xml");
        ICreator bean = context.getBean(ICreator.class);
        bean.createEasyAOP("Tom", "Cruise", 55);
        bean.queryEasyAOP();
    }
}
