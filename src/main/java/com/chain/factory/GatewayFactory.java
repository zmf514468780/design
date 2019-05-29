package com.chain.factory;

import com.chain.dao.ChainMapper;
import com.chain.domain.GatewayHandler;
import com.chain.service.GatewayHandlerService;
import com.chain.service.impl.BlacklistHandler;
import com.chain.service.impl.ConversationHandler;
import com.chain.service.impl.CurrentLimitHandler;
import com.contextstrategy.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
@Service
public class GatewayFactory {
    @Autowired
    private ChainMapper chainMapper;
    @Autowired
    private SpringUtils springUtils;
    public static GatewayHandlerService getGatewayHandler(){
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        BlacklistHandler blacklistHandler = new BlacklistHandler();
        ConversationHandler conversationHandler = new ConversationHandler();
        currentLimitHandler.setNextGatewayHandler(blacklistHandler);
        blacklistHandler.setNextGatewayHandler(conversationHandler);
        return currentLimitHandler;
    }

    public   GatewayHandlerService getGatewayHandlerBySql(){
        // 第一个
        GatewayHandler firstHandler = chainMapper.getFirstHandler();
        if(firstHandler == null){
            return null;
        }
        GatewayHandlerService gatewayHandlerService = springUtils.getBean(firstHandler.getHandler_id(), GatewayHandlerService.class);
        GatewayHandlerService temp = gatewayHandlerService;
        String nextHandlerId =  firstHandler.getNext_handler_id();
        while(nextHandlerId != null){
            // 调用service 方法
            // 获取到下一关
            GatewayHandler handler = chainMapper.getHandler(nextHandlerId);
            gatewayHandlerService = springUtils.getBean(handler.getHandler_id(), GatewayHandlerService.class);
            nextHandlerId = handler.getNext_handler_id();
//            nextBeanHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            temp.setNextGatewayHandler(gatewayHandlerService);
        }
        gatewayHandlerService = temp;
        return gatewayHandlerService;
    }
}
