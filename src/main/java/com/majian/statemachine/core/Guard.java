package com.majian.statemachine.core;

/**
 * Created by jianma on 2018/4/24.
 */
public interface Guard {

    boolean match(StateContext context);
}
