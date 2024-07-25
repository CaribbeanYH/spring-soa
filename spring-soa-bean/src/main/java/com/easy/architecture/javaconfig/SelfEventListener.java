package com.easy.architecture.javaconfig;

import com.easy.architecture.javaconfig.event.SelfEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SelfEventListener implements ApplicationListener<SelfEvent> {
    @Override
    public void onApplicationEvent(SelfEvent selfEvent) {
        System.out.println(selfEvent.toString());
    }
}
