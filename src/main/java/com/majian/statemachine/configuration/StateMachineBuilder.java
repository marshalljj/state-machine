package com.majian.statemachine.configuration;

import com.majian.statemachine.core.*;


/**
 * Created by jianma on 2018/4/24.
 */
public class StateMachineBuilder {

    private final StateConfig stateConfig = new StateConfig();
    private final EventPublisher eventPublisher = new EventPublisher();


    public StateMachine createInstance(String currentStateId) {
        State state = stateConfig.get(currentStateId);
        if (state == null) {
            throw new IllegalArgumentException("state not exists :" + currentStateId);
        }
        return new StateMachine(state, eventPublisher);
    }


    public void addTransition(TransitionProperties properties) {
        new TransitionBuilder(stateConfig)
                .from(properties.getFrom())
                .to(properties.getTo())
                .on(properties.getEvent())
                .when(properties.getGuard())
                .doAction(properties.getActions())
                .build();
    }

    public void onTransitionStarted(EventListener listener) {
        eventPublisher.register(listener);
    }


}
