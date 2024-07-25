package com.easy.architecture.config;


import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghai10
 * @ClassName AppConfig
 * @Description
 * @date 2024/7/25 14:44
 */
@Configuration
@ComponentScan(basePackages = "com.easy.architecture.config")
public class AppConfig {

    /**
     * 在标注有@Configuration的类中，
     * 通过使用@Bean注解，将非本项目的代码中的对象，
     * 放到spring的ioc容器中管理起来
     */
    @Bean(value = "GsonObject")
    public Gson generateGson() {
        return new Gson();
    }
}
