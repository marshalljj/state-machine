package com.majian.statemachine.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianma on 2018/4/25.
 */
public class StateConfig {
    private final Map<String, State> stateMap = new HashMap<>();

    public  State createIfNotExists(String stateId) {
        State state = stateMap.get(stateId);
        if (state == null) {
            state = new State(stateId);
        }
        stateMap.put(stateId, state);
        return state;
    }

    public  State get(String stateId) {
        return stateMap.get(stateId);
    }
}
