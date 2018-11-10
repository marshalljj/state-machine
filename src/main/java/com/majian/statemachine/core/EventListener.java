package com.majian.statemachine.core;

public interface EventListener<T> {
    boolean support(T t);

    void onEvent(T t);
}
