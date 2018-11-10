package com.majian.statemachine.core;

import java.util.Collection;


/**
 * Created by majian on 2017/7/19.
 */
public class StateMachine {

    private State current;
    private EventPublisher eventPublisher;

    public StateMachine(State current, EventPublisher eventPublisher) {
        this.current = current;
        this.eventPublisher = eventPublisher;
    }

    public boolean accept(String event) {
        return current.getTransition(event) != null;
    }

    public State onEvent(String event, StateContext context) {
        Transition transition = current.getTransition(event);
        if (transition == null) {
            throw new EventNotAcceptedException();
        }
        eventPublisher.publish(new TransitionStartEvent());
        Guard guard = transition.getGuard();
        if (guard != null && !guard.match(context)) {
            eventPublisher.publish(new ConditionNotSatisfiedEvent());
            return null;
        }

        Collection<Action> actions = transition.getActions();
        for (Action action : actions) {
            action.onTransition(context);
        }
        current = transition.getTarget();
        eventPublisher.publish(new TransitionCompletedEvent());
        return current;
    }


}
