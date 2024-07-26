package com.easy.archiecture.oldaop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

//方法执行之后，打印出返回值
public class LogResultAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("[advice]方法返回：" + returnValue);
    }
}
