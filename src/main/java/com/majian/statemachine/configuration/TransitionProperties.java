package com.majian.statemachine.configuration;

import java.util.List;

public class TransitionProperties {
    private String from;
    private String to;
    private String event;
    //spel
    private String guard;
    private List<String> actions;

    public TransitionProperties() {
    }

    public TransitionProperties(String from, String to, String event) {
        this.from = from;
        this.to = to;
        this.event = event;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
