package com.easy.archiecture.aspectjaop;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class ICreatorImpl implements ICreator {

    @Override
    public EasyAOP createEasyAOP(String firstName, String lastName, int age) {
        EasyAOP user = new EasyAOP();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @Override
    public EasyAOP queryEasyAOP() {
        EasyAOP user = new EasyAOP();
        user.setFirstName("test");
        user.setLastName("test");
        user.setAge(20);
        return user;
    }
}
