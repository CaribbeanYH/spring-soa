package com.easy.architecture.config;

import com.easy.architecture.config.event.SelfEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yanghai10
 * @ClassName SelfEventListener
 * @Description
 * @date 2024/7/25 14:44
 */
@Component
public class SelfEventListener implements ApplicationListener<SelfEvent> {
    @Override
    public void onApplicationEvent(SelfEvent selfEvent) {
        System.out.println(selfEvent.toString());
    }
}
