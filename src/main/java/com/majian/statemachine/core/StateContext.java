package com.majian.statemachine.core;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by jianma on 2018/4/24.
 */
public class StateContext {

    private EvaluationContext evaluationContext = new StandardEvaluationContext();

    public void setVariable(String name, Object value) {
        evaluationContext.setVariable(name, value);
    }

    public Object lookupVariable(String name) {
        return evaluationContext.lookupVariable(name);
    }

    public EvaluationContext getEvaluationContext() {
        return evaluationContext;
    }
}
