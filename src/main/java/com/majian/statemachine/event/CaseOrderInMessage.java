package com.majian.statemachine.event;

import com.majian.statemachine.Case;

/**
 * Created by majian on 2017/7/19.
 */
public class CaseOrderInMessage {
    private Case aCase;
    private String orderId;

    public Case getaCase() {
        return aCase;
    }

    public String getOrderId() {
        return orderId;
    }

    public CaseOrderInMessage(Case aCase, String orderId) {
        this.aCase = aCase;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CaseOrderInMessage{");
        sb.append("aCase=").append(aCase);
        sb.append(", orderId='").append(orderId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
