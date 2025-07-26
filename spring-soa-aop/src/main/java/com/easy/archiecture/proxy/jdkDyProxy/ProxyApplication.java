package com.easy.archiecture.proxy.jdkDyProxy;


/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class ProxyApplication {

    public static void main(String[] args) {

        //构造接口多态
        Animal animal = new Cat();
        Animal animal2 = new Dog();

        //传入需要被代理的对象
        AnimalProxyProvider animalProxyProvider = new AnimalProxyProvider(animal);
        AnimalProxyProvider animalProxyProvider2 = new AnimalProxyProvider(animal2);

        //得到代理对象
        /*
            注意！
            此处代理对象animalProxy的编译类型仍然是Animal类型，但运行类型却不再是Cat or Dog类型，
            而是代理类型 ——— class com.sun.proxy.$Proxy9。
         */
        Animal animalProxy = animalProxyProvider.getAnimalProxy();
        Animal animalProxy2 = animalProxyProvider2.getAnimalProxy();
        System.out.println("animalProxy's RuntimeType = " + animalProxy.getClass());
        System.out.println("animalProxy2's RuntimeType = " + animalProxy2.getClass());

        //通过代理对象调用实现类方法
        animalProxy.eat();
        System.out.println("==============================");
        animalProxy2.eat();
    }
}