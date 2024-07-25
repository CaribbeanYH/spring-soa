package com.easy.architecture.config;

import com.easy.architecture.config.event.SelfEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
@Component
public class SelfEvenetPub implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish() {
        SelfEvent selfEvent = new SelfEvent(this);
        publisher.publishEvent(selfEvent);
    }
}
