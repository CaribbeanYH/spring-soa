package com.easy.architecture.staticfactory;

public class American implements Person {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void say() {
        System.out.println(msg + "USA is my homeland");
    }
}
