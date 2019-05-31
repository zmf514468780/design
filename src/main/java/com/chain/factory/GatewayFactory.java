package com.chain.factory;

import com.chain.dao.ChainMapper;
import com.chain.domain.GatewayHandler;
import com.chain.service.GatewayHandlerService;
import com.chain.service.impl.BlacklistHandler;
import com.chain.service.impl.ConversationHandler;
import com.chain.service.impl.CurrentLimitHandler;
import com.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhumf
 * @Date 2019/5/23
 **/
@Service
public class GatewayFactory {
    @Autowired
    private ChainMapper chainMapper;
    @Autowired
    private SpringUtils springUtils;
    private GatewayHandlerService firstGatewayHandlerService;

    public static GatewayHandlerService getGatewayHandlerByEnmus() {
        GatewayHandlerService currentLimitHandler = new CurrentLimitHandler();
        GatewayHandlerService blacklistHandler = new BlacklistHandler();
        GatewayHandlerService conversationHandler = new ConversationHandler();
        currentLimitHandler.setNextGatewayHandler(blacklistHandler);
        blacklistHandler.setNextGatewayHandler(conversationHandler);
        return currentLimitHandler;
    }

    public GatewayHandlerService getGatewayHandlerBySql() {
        // 获取到第一个节点
        GatewayHandler firstHandler = chainMapper.getFirstHandler();
        if (firstHandler == null) {
            return null;
        }
        // 获取第一个类
        GatewayHandlerService firstGatewayHandler =
                springUtils.getBean(firstHandler.getHandler_id(), GatewayHandlerService.class);
        String nextBeanHandlerId = firstHandler.getNext_handler_id();
        GatewayHandlerService tempNextGatewayHandler = firstGatewayHandler;
        while (nextBeanHandlerId != null) {
            // 4.从SpringBoot容器获取下一个handler对象
            GatewayHandlerService nextGatewayHandler = springUtils.getBean(nextBeanHandlerId, GatewayHandlerService.class);
            if (nextGatewayHandler == null) {
                break;
            }
            // 5.从数据库查询该hanlder信息
            GatewayHandler nextGatewayHandlerEntity = chainMapper.getHandler(nextBeanHandlerId);
            if (nextGatewayHandlerEntity == null) {
                break;
            }
            // 6.设置下一个white循环遍历hanlderid
            nextBeanHandlerId = nextGatewayHandlerEntity.getNext_handler_id();
            tempNextGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            tempNextGatewayHandler = nextGatewayHandler;

        }
        this.firstGatewayHandlerService = firstGatewayHandler;
        return firstGatewayHandlerService;
    }

    public GatewayHandlerService getGatewayHandlerBySql2() {
        // 第一个
        GatewayHandler firstHandler = chainMapper.getFirstHandler();
        if (firstHandler == null) {
            return null;
        }
        GatewayHandlerService firstGatewayHandler = springUtils.getBean(firstHandler.getHandler_id(), GatewayHandlerService.class);
        GatewayHandlerService temp = firstGatewayHandler;
        String nextHandlerId = firstHandler.getNext_handler_id();
        while (nextHandlerId != null) {
            // 调用service 方法
            // 注释方法为错误
            //  firstGatewayHandler  = springUtils.getBean(nextHandlerId, GatewayHandlerService.class);
            GatewayHandlerService nextGatewayHandler = springUtils.getBean(nextHandlerId, GatewayHandlerService.class);
            // 获取到下一关
            GatewayHandler handler = chainMapper.getHandler(nextHandlerId);
            nextHandlerId = handler.getNext_handler_id();
            temp.setNextGatewayHandler(nextGatewayHandler);
            temp = nextGatewayHandler;
        }
        // this.firstGatewayHandlerService = temp;
        this.firstGatewayHandlerService = firstGatewayHandler;
        return firstGatewayHandlerService;
    }

    public static void main(String[] args) {
        // 这里演示为什么可以赋值成功    
        GatewayHandlerService currentLimitHandler = new CurrentLimitHandler();
        GatewayHandlerService temp = currentLimitHandler;
        GatewayHandlerService blacklistHandler = new BlacklistHandler();
        temp.setNextGatewayHandler(blacklistHandler);
        temp = blacklistHandler;
        GatewayHandlerService conversationHandler = new ConversationHandler();
        temp.setNextGatewayHandler(conversationHandler);
        System.out.println(currentLimitHandler);
        currentLimitHandler.service();
    }
}

