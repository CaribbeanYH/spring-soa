package com.easy.architecture.springFactory;

/**
 * @author yanghai
 * @ClassName
 * @Description
 * @date 2024/7/26 00:35
 */
public class YuJi implements Hero {

    private String desc;

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public void ability() {
        System.out.println("我的绝招是" + desc);
    }
}
