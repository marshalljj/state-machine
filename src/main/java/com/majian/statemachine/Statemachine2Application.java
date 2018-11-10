package com.majian.statemachine;

import com.google.common.collect.Lists;
import com.majian.statemachine.configuration.StateMachineBuilder;
import com.majian.statemachine.configuration.TransitionProperties;
import com.majian.statemachine.core.State;
import com.majian.statemachine.core.StateMachine;

import java.util.List;


public class Statemachine2Application {

    public static void main(String[] args) {
        StateMachineBuilder stateMachineBuilder = initStateMachineBuilder();

        StateMachine stateMachine = stateMachineBuilder.createInstance("state1");
        State state = stateMachine.onEvent("event1", null);
        System.out.println(state);

    }

    private static StateMachineBuilder initStateMachineBuilder() {
        StateMachineBuilder stateMachineBuilder = new StateMachineBuilder();
        List<TransitionProperties> transitionPropertiesList = getTransitionPropertiesList();
        for (TransitionProperties properties: transitionPropertiesList) {
            stateMachineBuilder.addTransition(properties);
        }
        stateMachineBuilder.onTransitionStarted(event -> System.out.println("transition started"));
        return stateMachineBuilder;
    }

    private static List<TransitionProperties> getTransitionPropertiesList() {
        TransitionProperties properties1 = new TransitionProperties("state1", "state2", "event1");
        TransitionProperties properties2 = new TransitionProperties("state1", "state3", "event2");
        TransitionProperties properties3 = new TransitionProperties("state1", "state4", "event2");
        return Lists.newArrayList(properties1,properties2, properties3);
    }
}
