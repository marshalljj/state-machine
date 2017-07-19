package com.majian.statemachine;

/**
 * Created by majian on 2017/7/19.
 */
public interface Action<T> {

    void onTransition(T data);
}
