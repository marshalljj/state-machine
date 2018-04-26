package com.majian.statemachine.core;

/**
 * Created by jianma on 2018/4/25.
 */
public class StateNotExistsException extends RuntimeException {
    public StateNotExistsException() {
    }

    public StateNotExistsException(String message) {
        super(message);
    }
}
