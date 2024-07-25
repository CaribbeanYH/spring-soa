package com.easy.architecture.javaconfig;

import com.easy.architecture.javaconfig.event.SelfEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class SelfEvenetPub implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(){
        SelfEvent selfEvent = new SelfEvent(this);
        publisher.publishEvent(selfEvent);
    }
}
