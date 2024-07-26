package com.easy.archiecture.aopannotation;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@Aspect
@Component
public class EasyAOP {

    @Pointcut("execution(* com.easy.archiecture.aopannotation..*.*(..))") // the pointcut expression
    private void aopPoint() {
    } // the pointcut signature


    @Before("com.easy.archiecture.aopannotation.EasyAOP.aopPoint()")
//    @After()
//    @Around()
    private void aop() {
        System.out.println("add----before");
    }
}
