package com.majian.statemachine.core;

import java.util.Collection;


/**
 * Created by majian on 2017/7/19.
 */
public class StateMachine {

    private State current;
    private EventPublisher eventPublisher;

    public StateMachine(State current) {
        this.current = current;
        this.eventPublisher = new EventPublisher();
    }

    public boolean accept(String event) {
        return current.getTransition(event) != null;
    }

    public void onEvent(String event, StateContext context) {
        Transition transition = current.getTransition(event);
        if (transition == null) {
            eventPublisher.publish(new EventNotAcceptedEvent());
            return;
        }

        Guard guard = transition.getGuard();
        if (!guard.match(context)) {
            eventPublisher.publish(new ConditionNotSatisfiedEvent());
            return;
        }

        Collection<Action> actions = transition.getActions();
        for (Action action : actions) {
            action.onTransition(context);
        }
        current = transition.getTarget();
        eventPublisher.publish(new TransitionCompletedEvent());

    }


}
