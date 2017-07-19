package com.majian.statemachine.event;

import com.majian.statemachine.Case;

/**
 * Created by majian on 2017/7/19.
 */
public class CaseSubmitMessage {
    private Case aCase;
    private String result;

    public Case getaCase() {
        return aCase;
    }


    public String getResult() {
        return result;
    }

    public CaseSubmitMessage(Case aCase, String result) {
        this.aCase = aCase;
        this.result = result;
    }
}
