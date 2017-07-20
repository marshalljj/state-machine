package com.majian.statemachine;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.majian.statemachine.annotation.TransitionListener;
import com.majian.statemachine.event.Event;
import com.majian.statemachine.state.State;
import com.majian.statemachine.transition.GeneralTransition;
import com.majian.statemachine.transition.Transition;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by majian on 2017/7/19.
 */
@Service
public class StateMachineConfig {

    @Autowired
    private List<Action> actions;

    private Table<State, Event, Transition> stateRelations = Tables.newCustomTable(
        Maps.<State, Map<Event, Transition>>newLinkedHashMap(),
        Maps::newLinkedHashMap
    );


    @PostConstruct
    private void init() {
        actions.forEach(action -> {
            TransitionListener[] annotations = action.getClass().getDeclaredAnnotationsByType(TransitionListener.class);
            for (TransitionListener annotation : annotations) {
                State source = annotation.source();
                State target = annotation.target();
                Event event = annotation.event();
                if (!stateRelations.contains(source, event)) {
                    GeneralTransition transition =
                        new GeneralTransition(source, event, target, Lists.newArrayList(action));
                    stateRelations.put(source, event, transition);
                } else {
                    Transition transition = stateRelations.get(source, event);
                    transition.addLisener(action);
                }
            }
        });
    }

    public Transition getTransition(State state, Event event) {
        return stateRelations.get(state, event);
    }

    public boolean containTransition(State state, Event event) {
        return stateRelations.contains(state, event);
    }

}
