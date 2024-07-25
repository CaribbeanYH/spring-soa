package com.easy.architecture.constructor;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName HeroCaoCao
 * @Description 曹操
 * @date 2024/7/25 14:44
 */
public class HeroCaoCao implements Serializable, InitializingBean {

    private String name;

    public HeroCaoCao() {
        System.out.println("------->init by no args constructor<--------");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void ability() {
        System.out.println("曹操的名字: " + name);
    }

    //    @PostConstruct 指定init的方式
    public void init() {
        System.out.println("init starting");
        this.name = "init running";
        System.out.println("init ending");
    }

    //@PostConstruct注解的代码执行 优先于 afterPropertiesSet()方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("end init starting");
        this.name = "afterPropertiesSet init running";
        System.out.println("end init ending");
    }
}
