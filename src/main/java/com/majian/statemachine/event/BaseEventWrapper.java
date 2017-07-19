package com.majian.statemachine.event;

/**
 * Created by majian on 2017/7/19.
 */
public abstract class BaseEventWrapper<T> {
    private Event event;
    private T data;

    public BaseEventWrapper(Event event, T data) {
        this.event = event;
        this.data = data;
    }

    public Event getEvent() {
        return event;
    }

    public T getData() {
        return data;
    }
}
