package com.majian.statemachine.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianma on 2018/4/25.
 */
public class FSM {
    private final Map<String, State> stateMap = new HashMap<>();

    public  State getState(String stateId) {
        State state = stateMap.get(stateId);
        if (state == null) {
            state = new State(stateId);
        }
        stateMap.put(stateId, state);
        return state;
    }

}
