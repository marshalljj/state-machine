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
@TransitionListener(source = State.CREATED, target = State.CREATED, event = Event.ORDER_IN)
public class TransitionListener1 implements Action<Object> {

    @Override
    public void onTransition(Object data) {
        System.out.println("create to create on orderIn");
        System.out.println(data.toString());
    }
}
