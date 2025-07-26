package com.easy.archiecture.proxy.jdkDyProxy;
 
/**
 * @author : Cyan_RA9
 * @version : 21.0
 */
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("小狗爱吃骨头捏~");
    }
}