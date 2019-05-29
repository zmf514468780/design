package com.chain.service.impl;

import com.chain.service.GatewayHandlerService;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
@Component
public class CurrentLimitHandler extends GatewayHandlerService {
    @Override
    public void service() {
        System.out.println("第一关 >>>>> ");
        nextService();
    }
}
