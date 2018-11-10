package com.majian.statemachine.core;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianma on 2018/4/25.
 */
public class EventPublisher {
    private List<EventListener> eventListeners = new LinkedList<>();

    public void publish(Object event) {
        eventListeners.forEach(eventListener -> eventListener.onEvent(event));
    }

    public void register(EventListener eventListener) {
        eventListeners.add(eventListener);
    }
}
