package com.majian.statemachine.event;

/**
 * Created by majian on 2017/7/19.
 */
public class OrderInEvent extends BaseEventWrapper<CaseOrderInMessage> {

    public OrderInEvent(Event event, CaseOrderInMessage data) {
        super(event, data);
    }
}
