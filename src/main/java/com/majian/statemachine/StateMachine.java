package com.majian.statemachine;

import com.majian.statemachine.event.BaseEventWrapper;
import com.majian.statemachine.state.State;
import com.majian.statemachine.transition.Transition;
import java.util.Collection;
import org.springframework.util.CollectionUtils;

/**
 * Created by majian on 2017/7/19.
 */
public class StateMachine {

    private State begin;
    private StateMachineConfig config;

    private StateMachine(State begin, StateMachineConfig config) {
        this.begin = begin;
        this.config = config;
    }

    public static StateMachine getInstance(State begin, StateMachineConfig config) {
        return new StateMachine(begin, config);
    }

    public <T> void onEvent(final BaseEventWrapper<T> event) {
        if (!config.containTransition(begin, event.getEvent())) {
            throw new UnsupportedOperationException();
        }
        Transition transition = config.getTransition(begin, event.getEvent());
        Collection<Action> listeners = transition.getListeners();
        if (CollectionUtils.isEmpty(listeners)) {
            throw new UnsupportedOperationException();
        }
        listeners.forEach(listener -> listener.onTransition(event.getData()));
    }


}
