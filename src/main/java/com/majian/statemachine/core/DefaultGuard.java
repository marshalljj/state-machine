package com.majian.statemachine.core;

/**
 * Created by jianma on 2018/4/24.
 */
public class DefaultGuard implements Guard{
    @Override
    public boolean match(StateContext context) {
        return true;
    }
}
