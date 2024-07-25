package com.easy.architecture.javaconfig.staregy;

import org.springframework.stereotype.Service;

@Service("xyz")
public class Teacher implements Person{

    private String email;


    @Override
    public void write() {
        System.out.println("teacher");
    }
}
