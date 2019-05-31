package com.ob.test;

import com.ob.service.ObServer;
import com.ob.service.impl.UserObServer;
import com.ob.service.impl.WxSubject;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/31
 **/
public class TestMain {
    public static void main(String[] args) {
        WxSubject wxSubject = new WxSubject();
        wxSubject.addObServer(new UserObServer("ddd"));
        wxSubject.setNotifyMessage("ddd");
    }
}
