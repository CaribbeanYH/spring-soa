package com.easy.architecture.javaconfig.event;

import org.springframework.context.ApplicationEvent;

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
