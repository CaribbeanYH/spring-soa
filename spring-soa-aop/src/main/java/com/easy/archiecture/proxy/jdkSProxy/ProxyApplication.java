package com.easy.archiecture.proxy.jdkSProxy;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2025/7/26 12:58
 */
public class ProxyApplication {

    public static void main(String[] args) {
        Cat animal = new Cat();
        ProxyCat animalProxyProvider = new ProxyCat(animal);
        animalProxyProvider.eat();
    }
}
