package com.majian.statemachine.event;

import com.majian.statemachine.Case;

/**
 * Created by majian on 2017/7/19.
 */
public class CaseDistributeMessage {

    private Case aCase;
    private String recipient;

    public CaseDistributeMessage(Case aCase, String recipient) {
        this.aCase = aCase;
        this.recipient = recipient;
    }

    public Case getaCase() {
        return aCase;
    }


    public String getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CaseDistributeMessage{");
        sb.append("aCase=").append(aCase);
        sb.append(", recipient='").append(recipient).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
