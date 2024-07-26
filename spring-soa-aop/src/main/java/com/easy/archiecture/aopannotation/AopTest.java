package com.easy.archiecture.aopannotation;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {


    @Pointcut("execution(* com.easy.archiecture.springaop.aopannotation..*.*(..))") // the pointcut expression
    private void anyOldTransfer() {
    } // the pointcut signature


    @Before("com.easy.archiecture.springaop.aopannotation.AopTest.anyOldTransfer()")
//    @After()
//    @Around()
    private void addBeforePrint() {
        System.out.println("add----before");
    }
}
