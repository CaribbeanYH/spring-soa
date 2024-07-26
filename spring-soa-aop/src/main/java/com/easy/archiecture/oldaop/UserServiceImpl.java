package com.easy.archiecture.oldaop;

public class UserServiceImpl implements UserService{
    @Override
    public UserTest createUser(String firstName, String lastName, int age) {
        UserTest user = new UserTest();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @Override
    public UserTest queryUser() {
        UserTest user = new UserTest();
        user.setFirstName("test");
        user.setLastName("test");
        user.setAge(20);
        return user;
    }
}
