package com.majian.statemachine.configuration;

import com.majian.statemachine.core.FSM;
import com.majian.statemachine.core.StateMachine;


/**
 * Created by jianma on 2018/4/24.
 */
public class StateMachineBuilder {

    private final FSM fsm = new FSM();


    public TransitionBuilder withTransition() {
        TransitionBuilderImpl transitionBuilder = new TransitionBuilderImpl(fsm);
        return transitionBuilder;
    };

    public StateMachine createInstance(String currentStateId) {
        return new StateMachine(fsm.getState(currentStateId));
    }


}
