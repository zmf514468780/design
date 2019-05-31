package com.Template.Controller;

import com.Template.factory.TemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
@RestController
public class TemplateController {
    @Autowired
    private TemplateFactory factory;
    @RequestMapping("/templatePay")
    public void templatePay(String payType){
        factory.getAbstractPayCallbackTemplate(payType).asyncCallBack();
    }
}
