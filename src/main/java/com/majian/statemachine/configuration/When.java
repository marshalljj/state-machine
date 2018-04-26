package com.majian.statemachine.configuration;

import com.majian.statemachine.core.Action;

/**
 * Created by jianma on 2018/4/25.
 */
public interface When {
    void doAction(Action... action);
}
