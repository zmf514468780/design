package com.chain.domain;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
public class GatewayHandler {
    private Integer ID;
    private String handler_name;
    private String handler_id;
    private String prev_handler_id;
    private String next_handler_id;
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getHandler_name() {
        return handler_name;
    }

    public void setHandler_name(String handler_name) {
        this.handler_name = handler_name;
    }

    public String getHandler_id() {
        return handler_id;
    }

    public void setHandler_id(String handler_id) {
        this.handler_id = handler_id;
    }

    public String getPrev_handler_id() {
        return prev_handler_id;
    }

    public void setPrev_handler_id(String prev_handler_id) {
        this.prev_handler_id = prev_handler_id;
    }

    public String getNext_handler_id() {
        return next_handler_id;
    }

    public void setNext_handler_id(String next_handler_id) {
        this.next_handler_id = next_handler_id;
    }

    @Override
    public String toString() {
        return "GatewayHandler{" +
                "ID=" + ID +
                ", handler_name='" + handler_name + '\'' +
                ", handler_id='" + handler_id + '\'' +
                ", prev_handler_id='" + prev_handler_id + '\'' +
                ", next_handler_id='" + next_handler_id + '\'' +
                '}';
    }
}
