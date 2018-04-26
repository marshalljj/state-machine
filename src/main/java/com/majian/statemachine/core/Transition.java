package com.majian.statemachine.core;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by majian on 2017/7/19.
 */
public class Transition {
    private State source;
    private State target;
    private String event;
    private Collection<Action> actions;
    private Guard guard;

    public Transition(State source, String event, State target) {
        this.source = source;
        this.target = target;
        this.event = event;
        this.actions = new ArrayList<>();
        this.guard = new DefaultGuard();
    }

    public State getSource() {
        return source;
    }

    public State getTarget() {
        return target;
    }

    public String getEvent() {
        return event;
    }

    public Collection<Action> getActions() {
        return actions;
    }

    public Guard getGuard() {
        return guard;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }

    public void addAction(Action action) {
        actions.add(action);
    }
}
