package com.easy.archiecture.proxy.cglib;


import com.easy.archiecture.proxy.jdkDyProxy.Cat;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class ProxyApplication {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class);
        enhancer.setCallback(new AnimalMethodInterceptor());
        Cat proxy = (Cat) enhancer.create();
        proxy.eat();
    }
}