package com.majian.statemachine;

import com.majian.statemachine.event.CaseDistributeMessage;
import com.majian.statemachine.event.CaseOrderInMessage;
import com.majian.statemachine.event.CaseSubmitMessage;
import com.majian.statemachine.event.DistributeEvent;
import com.majian.statemachine.event.Event;
import com.majian.statemachine.event.OrderInEvent;
import com.majian.statemachine.event.SubmitEvent;
import com.majian.statemachine.state.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by majian on 2017/7/19.
 */
@Service
public class CaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StateMachineConfig stateMachineConfig;

    public void orderIn(String caseId, String orderId) {
        Case acase = getCase(caseId);
        CaseOrderInMessage caseOrderInMessage = new CaseOrderInMessage(acase, orderId);
        StateMachine stateMachine = StateMachine.getInstance(acase.getState(), stateMachineConfig);
        stateMachine.onEvent(new OrderInEvent(Event.ORDER_IN, caseOrderInMessage));
    }

    public void distribute(String caseId, String recipient) {
        Case aCase = getCase(caseId);
        CaseDistributeMessage caseDistributeMessage = new CaseDistributeMessage(aCase, recipient);
        StateMachine stateMachine = StateMachine.getInstance(aCase.getState(), stateMachineConfig);
        stateMachine.onEvent(new DistributeEvent(Event.DISTRIBUTE, caseDistributeMessage));
    }

    private Case getCase(String caseId) {
        String sql = "select * from cases where id = ?";
        Case aCase = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            Case aCase1 = new Case();
            aCase1.setId(resultSet.getString(1));
            aCase1.setName(resultSet.getString(2));
            aCase1.setCreate(resultSet.getDate(3));
            String stateStr = resultSet.getString(4);
            aCase1.setState(State.valueOf(stateStr));
            return aCase1;
        }, caseId);
        return aCase;
    }

    public void submit(String caseId, String result) {
        Case aCase = getCase(caseId);
        StateMachine stateMachine = StateMachine.getInstance(aCase.getState(), stateMachineConfig);
        stateMachine.onEvent(new SubmitEvent(Event.SUBMIT, new CaseSubmitMessage(aCase, result)));
    }
}
