package com.Template.factory;

import com.Template.service.AbstractPayCallbackTemplate;
import com.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
@Component
public class TemplateFactory {
    @Autowired
    private SpringUtils springUtils;
    public   AbstractPayCallbackTemplate getAbstractPayCallbackTemplate(String payTpye){
        AbstractPayCallbackTemplate abstractPayCallbackTemplate = (AbstractPayCallbackTemplate) springUtils.getBean(payTpye);
        return  abstractPayCallbackTemplate;
    }
}
