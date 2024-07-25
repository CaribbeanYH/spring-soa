package com.easy.architecture.factory;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yanghai10
 * @ClassName Business
 * @Description 曹操
 * @date 2024/7/25 14:44
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Business {

    BusinessType[] businessTypes();
}
