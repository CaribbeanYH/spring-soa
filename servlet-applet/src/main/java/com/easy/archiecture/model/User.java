package com.easy.archiecture.model;

import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2025/8/17 11:02
 */
public class User implements Serializable {

    private String username;

    private Integer userAge;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
