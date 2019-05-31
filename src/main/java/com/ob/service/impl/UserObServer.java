package com.ob.service.impl;

import com.ob.service.ObServer;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
public class UserObServer implements ObServer {
    /**
     * 订阅者用户名称
     */
    private String name;

    /**
     * 发送内容
     */
    private String message;

    public UserObServer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }
    private void read() {
        System.out.println(name + ",老师收到推送消息:" + message);
    }
}
