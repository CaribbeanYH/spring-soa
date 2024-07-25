package com.easy.architecture.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author yanghai10
 * @ClassName ContextListener
 * @Description
 * @date 2024/7/25 14:44
 */
@Component
public class ContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("spring ioc refreshed success");
    }
}
