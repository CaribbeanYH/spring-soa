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


    /**
     Advice: org.aopalliance.aop.Advice
     “通知”，表示 Aspect 在特定的 Join point 采取的操作。包括 “around”, “before” and “after 等

     Pointcut: org.springframework.aop.Pointcut
     “切点”，它是用来匹配连接点 Join point 的，可以说"Pointcut"表示的是"Join point"的集合。

     Advisor: org.springframework.aop.Advisor
     “通知者”，它持有 Advice，是 Spring AOP 的一个基础接口。

     Advised: org.springframework.aop.framework.Advised
     AOP 代理工厂配置类接口。提供了操作和管理 Advice 和 Advisor 的能力


     Advice: org.aopalliance.aop.Advice
     “通知”，表示 Aspect 在特定的 Join point 采取的操作。包括 “around”, “before” and “after 等
     Advice 大体上分为了三类：BeforeAdvice、MethodInterceptor、AfterAdvice
     MethodInterceptor 是功能最强大的，是一个通用的方法拦截接口，它能够处理 BeforeAdvice、AroundAdvice、AfterAdvice、ThrowsAdvice、@Valid方法参数校验、@Async异步等

     Advisor: org.springframework.aop.Advisor
     “通知者”，它持有 Advice，是 Spring AOP 的一个基础接口。
     它的子接口 PointcutAdvisor 是一个功能完善接口，它涵盖了绝大部分的 Advisor。

     Advised: org.springframework.aop.framework.Advised
     AOP 代理工厂配置类接口。提供了操作和管理 Advice 和 Advisor 的能力。
     */
}
