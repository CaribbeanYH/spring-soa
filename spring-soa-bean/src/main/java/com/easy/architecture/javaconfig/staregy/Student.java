package com.easy.architecture.javaconfig.staregy;

import org.springframework.stereotype.Service;

@Service("abc")
public class Student implements Person{

    private String name;

    @Override
    public void write() {
        System.out.println("student");
    }
}
