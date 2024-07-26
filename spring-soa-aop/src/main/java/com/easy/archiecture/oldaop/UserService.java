package com.easy.archiecture.oldaop;


public interface UserService {
    UserTest createUser(String firstName, String lastName, int age);

    UserTest queryUser();
}
