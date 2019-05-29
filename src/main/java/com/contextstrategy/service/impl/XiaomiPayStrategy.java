package com.contextstrategy.service.impl;

import com.contextstrategy.service.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/8
 **/
@Component
public class XiaomiPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用小米支付接口";
    }
}
