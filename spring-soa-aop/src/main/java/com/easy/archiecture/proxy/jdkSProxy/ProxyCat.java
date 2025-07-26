package com.easy.archiecture.proxy.jdkSProxy;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2025/7/26 12:57
 */
public class ProxyCat implements Animal {

    /**
     * 目标猫对象，用于被代理。
     */
    private Cat target;

    /**
     * 创建一个代理猫对象，用于操作目标猫。
     *
     * @param target 目标猫对象
     */
    public ProxyCat(Cat target) {
        this.target = target;
    }

    @Override
    public void eat() {
        before();
        target.eat();
        after();
    }

    /**
     * 在方法调用前打印提示信息。
     */
    private void before() {
        System.out.println("Before method call");
    }

    /**
     * 在方法执行后打印一条信息。
     */
    private void after() {
        System.out.println("After method call");
    }
}
