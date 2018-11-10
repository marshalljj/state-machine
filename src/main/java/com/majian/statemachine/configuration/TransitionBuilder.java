package com.majian.statemachine.configuration;

import com.majian.statemachine.core.*;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.stream.Collectors;


/**
 * Created by jianma on 2018/4/25.
 */
public class TransitionBuilder {
    private State source;
    private State target;
    private String event;
    private Guard guard;
    private Collection<Action> actions;

    private StateConfig stateConfig;

    public TransitionBuilder(StateConfig stateConfig) {
        this.stateConfig = stateConfig;
    }

    public TransitionBuilder from(String source) {
        this.source = stateConfig.createIfNotExists(source);
        return this;
    }

    public TransitionBuilder to(String to) {
        this.target = stateConfig.createIfNotExists(to);
        return this;
    }

    public TransitionBuilder on(String event) {
        this.event = event;
        return this;
    }

    public TransitionBuilder when(String expression) {
        if (expression != null) {
            this.guard = new DefaultGuard(expression);
        }
        return this;
    }


    public TransitionBuilder doAction(Collection<String> actionNames) {
        if (actionNames != null) {
            this.actions = actionNames.stream()
                                      .map(ActionRegistry::getAction)
                                      .collect(Collectors.toList());
        }
        return this;
    }

    public Transition build() {
        Assert.notNull(source, "source state can't null");
        Assert.notNull(target, "target state can't null");
        Assert.notNull(event, "event can't null");
        Transition transition = new Transition(source, event, target);
        transition.setGuard(guard);
        transition.setActions(actions);
        source.addTransition(transition);
        return transition;
    }

}
