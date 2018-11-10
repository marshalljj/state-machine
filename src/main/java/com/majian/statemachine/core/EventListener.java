package com.majian.statemachine.core;

public interface EventListener<T> {

    void onEvent(T t);
}
