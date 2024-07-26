package com.easy.archiecture.aspectjaop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
//方法执行之后，打印出返回值
@Slf4j
public class LogResultAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        log.info("[advice]方法返回：" + returnValue);
    }
}
