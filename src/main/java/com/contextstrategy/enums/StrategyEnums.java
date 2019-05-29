package com.contextstrategy.enums;

public enum StrategyEnums {
    ali_pay("com.contextstrategy.service.impl.AliPayStrategy");
    StrategyEnums(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
