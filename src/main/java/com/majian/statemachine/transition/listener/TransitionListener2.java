package com.majian.statemachine.transition.listener;

import com.majian.statemachine.Action;
import com.majian.statemachine.annotation.TransitionListener;
import com.majian.statemachine.event.Event;
import com.majian.statemachine.state.State;
import org.springframework.stereotype.Component;

/**
 * Created by majian on 2017/7/19.
 */
@Component
@TransitionListener(source = State.CREATED, event = Event.DISTRIBUTE, target = State.DISTRIBUTED)
public class TransitionListener2 implements Action<Object>{

    @Override
    public void onTransition(Object data) {
        System.out.println("created to distributed on distribute");
        System.out.println(data.toString());
    }
}
