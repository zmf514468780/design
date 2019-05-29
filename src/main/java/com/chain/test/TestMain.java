package com.chain.test;

import com.chain.factory.GatewayFactory; 
/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
public class TestMain {
    public static void main(String[] args) {
        GatewayFactory.getGatewayHandler().service();
    }   
}
        