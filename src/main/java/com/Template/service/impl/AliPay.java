package com.Template.service.impl;

import com.Template.service.AbstractPayCallbackTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
@Component
@Slf4j
public class AliPay extends AbstractPayCallbackTemplate{
    @Override
    protected String asyncService(Map<String, String> verifySignatureMap) {
        String paymentStatus = verifySignatureMap.get("aliPayMentStatus");
        if (paymentStatus.equals("1")) {
            String aliPayOrderNumber = verifySignatureMap.get("aliPayOrderNumber");
             log.info( ">>>>orderNumber:{},已经支付成功 修改订单状态为已经支付...",aliPayOrderNumber );
        }
        return resultSuccess();
 
    }

    @Override
    protected String resultFail() {
        return "error";
    }

    @Override
    protected Map<String, String> verifySignature() {
        Map<String,String> map = new HashMap<>();
        map.put("analysisCode","200");
        map.put("aliPayMentStatus","1");
        map.put("aliPayOrderNumber","11111111111111111111111111111");
        return map;
    }

    @Override
    protected String resultSuccess() {
        return "success";
    }
}
