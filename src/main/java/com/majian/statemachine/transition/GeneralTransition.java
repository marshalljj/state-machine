package com.majian.statemachine.transition;

import com.majian.statemachine.Action;
import com.majian.statemachine.event.Event;
import com.majian.statemachine.state.State;
import java.util.Collection;

/**
 * Created by majian on 2017/7/19.
 */
public class GeneralTransition implements Transition {
    private State source;
    private State target;
    private Event event;
    private Collection listeners;

    public GeneralTransition(State source, Event event, State target, Collection listeners) {
        this.source = source;
        this.target = target;
        this.event = event;
        this.listeners = listeners;
    }

    @Override
    public Collection<Action> getListeners() {
        return listeners;
    }

    @Override
    public void addLisener(Action listener) {
        listeners.add(listener);
    }
}
