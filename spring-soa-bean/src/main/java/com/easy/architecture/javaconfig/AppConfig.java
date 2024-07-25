package com.easy.architecture.javaconfig;


import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.easy.architecture.javaconfig")
public class AppConfig {


    /**
     * 在标注有@Configuration的类中，通过使用@Bean注解，将非本项目的代码中的对象，放到spring的ioc容器中管理起来
     * @return
     */
    @Bean(value = "GsonObject")
    public Gson generateGson(){
        return new Gson();
    }
}
