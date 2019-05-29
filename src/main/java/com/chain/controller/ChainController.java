package com.chain.controller;

import com.chain.dao.ChainMapper;
import com.chain.domain.GatewayHandler;
import com.chain.factory.GatewayFactory;
import com.chain.service.GatewayHandlerService;
import com.contextstrategy.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
@RestController
public class ChainController {
    @Autowired
    private ChainMapper chainMapper;
    @Autowired
    private SpringUtils springUtils;
    @Autowired
    private GatewayFactory factory;
    @RequestMapping("/chain")
    public void chain(){
        System.out.println("ccc");
    }
    @RequestMapping("/getFirstChain")
    public Object getFirstChain(){
        return  chainMapper.getFirstHandler();
    }

    @RequestMapping("/getChain")
    public Object getChain(){
        return  chainMapper.getHandler("currentLimitHandler");
    }

    @RequestMapping("/chainService")
    public void chainService(){
        GatewayHandlerService service=factory.getGatewayHandlerBySql();
        service.service();
        System.out.println("=================================");
        factory.getGatewayHandlerBySql2().service();
    }

}
