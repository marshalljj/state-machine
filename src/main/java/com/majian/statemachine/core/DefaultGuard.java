package com.majian.statemachine.core;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by jianma on 2018/4/24.
 */
public class DefaultGuard implements Guard {
    Expression expression;

    public DefaultGuard(String expressionStr) {
        expression = new SpelExpressionParser().parseExpression(expressionStr);
    }

    @Override
    public boolean match(StateContext context) {
        return expression.getValue(context.getEvaluationContext(), Boolean.class);
    }
}
