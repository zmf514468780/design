package com.Template.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
@Slf4j
public abstract class AbstractPayCallbackTemplate {
    
    /**
     *@Author zhumf
     *@Description  //  异步回调接口
     *@Date 2019/5/31
     *@Param []
     *@return java.lang.String
    */
    public String asyncCallBack(){
        //1. 支付回调参数验证
        Map<String, String> verifySignatureMap = verifySignature();
        // 2.参数验证，写入日志
        payLog(verifySignatureMap);
        //3.执行回调异步相关逻辑
       String analysisCode =  verifySignatureMap.get("analysisCode");
       // 如果回调失败，返回错误结果
       if(!"200".equals(analysisCode)){
           return  resultFail();
       }
        return asyncService(verifySignatureMap);
    }

    protected abstract String asyncService(Map<String, String> verifySignatureMap);

    protected abstract String resultFail() ;
    @Async
    public void payLog(Map<String, String> verifySignatureMap) {
       log.info("这里插入日志:{}",verifySignatureMap);
    }
    protected abstract Map<String, String> verifySignature()  ;

    protected abstract String resultSuccess();

}
