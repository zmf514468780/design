package com.contextstrategy.service.impl;

import com.contextstrategy.service.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/8
 **/
@Component
public class AliPayStrategy implements PayStrategy {

    @Override
    public String toPayHtml() {
        return "调用支付宝接口";
    }

}
