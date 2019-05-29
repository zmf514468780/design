package com.chain.service;

import com.chain.domain.GatewayHandler;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
public abstract  class GatewayHandlerService {
    protected GatewayHandlerService nextGatewayHandler;

    /**
     * 处理业务逻辑
     *
     * @return true 表示继续执行 false表示不继续执行..
     */
    public abstract void service();

    public void setNextGatewayHandler(GatewayHandlerService gatewayHandler) {
        this.nextGatewayHandler = gatewayHandler;
    }
    protected void nextService(){
        if(nextGatewayHandler!=null){
            nextGatewayHandler.service();;
        }
    }

}
