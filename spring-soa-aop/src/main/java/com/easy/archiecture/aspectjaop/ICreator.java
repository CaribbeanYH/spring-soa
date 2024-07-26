package com.easy.archiecture.aspectjaop;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public interface ICreator {
    EasyAOP createEasyAOP(String firstName, String lastName, int age);

    EasyAOP queryEasyAOP();
}
