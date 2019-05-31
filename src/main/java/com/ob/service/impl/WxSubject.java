package com.ob.service.impl;

import com.ob.service.AbstractSubject;
import com.ob.service.ObServer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
public class WxSubject implements AbstractSubject {

    private List<ObServer> list = new ArrayList<>();

    private String message;
    @Override
    public void addObServer(ObServer obServer) {
        list.add(obServer);
    }

    @Override
    public void removeObServer(ObServer obServer) {
        list.remove(obServer);
    }

    @Override
    public void notifyObServer(String message) {
        for (int i = 0; i < list.size(); i++) {
            ObServer obServer = list.get(i);
            obServer.update(message);
        }
    }

    @Override
    public void setNotifyMessage(String message) {
        this.message= message;
        System.out.println("xiaoxi:"+message);
        notifyObServer(message);
    }
}
