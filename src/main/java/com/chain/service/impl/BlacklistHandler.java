package com.chain.service.impl;

import com.chain.service.GatewayHandlerService;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
@Component
public class BlacklistHandler extends GatewayHandlerService {
    @Override
    public void service() {
        System.out.println("第二关 >>>>> ");
        nextService();
    }
}
