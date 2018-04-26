package com.majian.statemachine.configuration;

import com.majian.statemachine.core.*;


/**
 * Created by jianma on 2018/4/25.
 */
public class TransitionBuilderImpl implements TransitionBuilder, From, To, On, When {
    private FSM fsm;
    private State source;
    private State target;
    private Transition transition;

    public TransitionBuilderImpl(FSM fsm) {
        this.fsm = fsm;
    }

    @Override
    public From from(String source) {
        this.source = fsm.getState(source);
        return this;
    }

    @Override
    public To to(String to) {
        this.target = fsm.getState(to);
        return this;
    }

    @Override
    public On on(String event) {
        this.transition = new Transition(source, event, target);
        source.addTransition(transition);
        return this;
    }

    @Override
    public When when(Guard guard) {
        if (guard != null) {
            transition.setGuard(guard);
        }
        return this;
    }


    @Override
    public void doAction(Action... actions) {
        for (Action action : actions) {
            this.transition.addAction(action);
        }
    }

}
