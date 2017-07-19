package com.majian.statemachine.transition;

import com.majian.statemachine.Action;
import java.util.Collection;

/**
 * Created by majian on 2017/7/19.
 */
public interface Transition {

    Collection<Action> getListeners();

    void addLisener(Action listener);

}
