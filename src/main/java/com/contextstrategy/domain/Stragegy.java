package com.contextstrategy.domain;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/21
 **/
public class Stragegy {
    private Integer id;
    private String CHANNEL_NAME;
    private String CHANNEL_ID;
    private String strategy_bean_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCHANNEL_NAME() {
        return CHANNEL_NAME;
    }

    public void setCHANNEL_NAME(String CHANNEL_NAME) {
        this.CHANNEL_NAME = CHANNEL_NAME;
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public void setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    public String getStrategy_bean_id() {
        return strategy_bean_id;
    }

    public void setStrategy_bean_id(String strategy_bean_id) {
        this.strategy_bean_id = strategy_bean_id;
    }
}
