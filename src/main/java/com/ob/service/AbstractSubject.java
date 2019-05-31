package com.ob.service;

/**
 * @Description 抽象主题者
 * @Author zhumf
 * @Date 2019/5/31
 **/
public interface AbstractSubject {
    void addObServer(ObServer obServer);
    void removeObServer(ObServer obServer);
    void notifyObServer(String message);
    void setNotifyMessage(String message);
}
