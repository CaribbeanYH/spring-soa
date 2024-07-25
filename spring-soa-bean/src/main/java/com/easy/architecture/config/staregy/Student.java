package com.easy.architecture.config.staregy;

import org.springframework.stereotype.Service;

/**
 * @author yanghai10
 * @ClassName Student
 * @Description
 * @date 2024/7/25 14:44
 */
@Service("student")
public class Student implements Role {

    private String name;

    @Override
    public void function() {
        System.out.println("student");
    }
}
