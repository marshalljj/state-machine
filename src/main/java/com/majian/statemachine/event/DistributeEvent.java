package com.majian.statemachine.event;

/**
 * Created by majian on 2017/7/19.
 */
public class DistributeEvent extends BaseEventWrapper<CaseDistributeMessage> {

    public DistributeEvent(Event event, CaseDistributeMessage data) {
        super(event, data);
    }
}
