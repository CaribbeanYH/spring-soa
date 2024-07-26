package com.easy.archiecture.aopannotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@SuppressWarnings("ALL")
@Aspect
@Component
public class EasyMonitorAspect {

    private final static Integer DEFAULT_SYSTEM_ERROR = 500;

    @Pointcut("@annotation(com.easy.archiecture.aopannotation.EasyMonitor)")
    public void point() {
    }

    @Around(value = "point()")
    public Object aroundUMP(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class returnType = signature.getReturnType();
        String classname = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        try {
            System.out.println("EasyMonitorAspect 切面生效了");
            return joinPoint.proceed();
        } catch (Exception exception) {
            return null;
        }
    }
}
