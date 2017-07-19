package com.majian.statemachine;

import com.majian.statemachine.state.State;
import java.util.Date;

/**
 * Created by majian on 2017/7/19.
 */
public class Case {

    private String id;
    private String name;
    private Date create;
    private State state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Case{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", create=").append(create);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
