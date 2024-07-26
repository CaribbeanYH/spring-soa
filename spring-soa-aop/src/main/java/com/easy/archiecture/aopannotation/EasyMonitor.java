package com.easy.archiecture.aopannotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Order(1)
public @interface EasyMonitor {

    /**
     * 方法的描述
     */
    String desc() default "";
}
