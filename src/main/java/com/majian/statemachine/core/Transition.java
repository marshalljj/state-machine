package com.majian.statemachine.core;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by majian on 2017/7/19.
 */
public class Transition {
    private State source;
    private String event;
    private State target;
    private Collection<Action> actions;
    private Guard guard;

    public Transition(State source, String event, State target) {
        this(source, event, target, null, null);
    }

    public Transition(State source, String event, State target, Collection<Action> actions, Guard guard) {
        this.source = source;
        this.target = target;
        this.event = event;
        this.actions = actions;
        this.guard = guard;
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
        return actions == null ? Collections.emptyList() : actions;
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

    public void setActions(Collection<Action> actions) {
        this.actions = actions;
    }
}
