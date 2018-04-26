package com.majian.statemachine.core;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by majian on 2017/7/19.
 */
public class State {
    private String name;
    private Map<String, Transition> route = new HashMap<>();

    public void addTransition(Transition transition) {
        route.put(transition.getEvent(), transition);
    }

    public State(String name) {
        this.name = name;
    }

    public Transition getTransition(String event) {
        return route.getOrDefault(event, null);
    }

    public String getName() {
        return name;
    }
}
