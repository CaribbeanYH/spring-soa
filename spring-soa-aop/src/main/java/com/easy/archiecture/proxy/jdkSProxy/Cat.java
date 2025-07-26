package com.easy.archiecture.proxy.jdkSProxy;

import com.easy.archiecture.proxy.jdkDyProxy.Animal;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("小猫爱吃鱼捏~");
    }
}