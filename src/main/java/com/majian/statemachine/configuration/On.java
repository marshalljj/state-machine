package com.majian.statemachine.configuration;

import com.majian.statemachine.core.Guard;

/**
 * Created by jianma on 2018/4/24.
 */
public interface On {
    When when(Guard guard);
}
