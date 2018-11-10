package com.majian.statemachine.core;

import java.util.HashMap;
import java.util.Map;

public class ActionRegistry {
    private static final Map<String, Action> mapping = new HashMap<>();

    public static void add(Action action) {
        mapping.put(action.getName(), action);
    }

    public static Action getAction(String name) {
        return mapping.get(name);
    }

}
