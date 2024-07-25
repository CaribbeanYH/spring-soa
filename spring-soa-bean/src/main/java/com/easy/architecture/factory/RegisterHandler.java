package com.easy.architecture.factory;

/**
 * @author yanghai10
 * @ClassName RegisterHandler
 * @Description
 * @date 2024/7/25 14:44
 */
@Business(businessTypes = BusinessType.REGISTER)
public class RegisterHandler implements Handler {
    @Override
    public void handle() {
        System.out.println("注册事件处理完成");
    }
}
