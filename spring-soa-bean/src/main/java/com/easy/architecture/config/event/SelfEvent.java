package com.easy.architecture.config.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yanghai10
 * @ClassName SelfEvent
 * @Description
 * @date 2024/7/25 14:44
 */
public class SelfEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5180127122881839358L;

    public SelfEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "my Event";
    }
}
