package com.majian.statemachine.annotation;

import com.majian.statemachine.event.Event;
import com.majian.statemachine.state.State;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by majian on 2017/7/19.
 * source
 * target
 * event
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TransitionListener {
    State source();
    State target();
    Event event();
}
