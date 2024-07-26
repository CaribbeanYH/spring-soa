package com.easy.archiecture.aspectjaop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
//在方法调用之前，打印调用该方法的参数
@Slf4j
public class LogArgsAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("[advice]准备执行方法: " + method.getName() + ", 参数列表：" + Arrays.toString(objects));
    }
}
