package com.contextstrategy.utils;

import com.contextstrategy.StrategyEnums;
import com.contextstrategy.service.PayStrategy;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/22
 **/
public class StrategyUtils {
    public static PayStrategy getPayStrategy(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       String className =  StrategyEnums.valueOf(name).getName();
          return (PayStrategy) Class.forName(className).newInstance();
    }
}
