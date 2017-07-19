package com.majian.statemachine.event;

/**
 * Created by majian on 2017/7/19.
 */
public class SubmitEvent extends BaseEventWrapper<CaseSubmitMessage>{

    public SubmitEvent(Event event, CaseSubmitMessage data) {
        super(event, data);
    }
}
