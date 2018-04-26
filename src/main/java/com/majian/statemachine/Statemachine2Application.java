package com.majian.statemachine;

import com.majian.statemachine.configuration.StateMachineBuilder;
import com.majian.statemachine.core.StateMachine;


public class Statemachine2Application {

    public static void main(String[] args) {
        StateMachineBuilder stateMachineBuilder = new StateMachineBuilder();

        stateMachineBuilder
                .withTransition()
                .from("state1")
                .to("state2")
                .on("event1")
                .when(null)
                .doAction(x -> System.out.println("aa"));
        StateMachine stateMachine = stateMachineBuilder.createInstance("state1");
        stateMachine.onEvent("event2", null);

    }
}
