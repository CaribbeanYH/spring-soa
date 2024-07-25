package com.easy.architecture.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;
/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@Component
public class ContextStopLIstener implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("stop application context");
    }
}
