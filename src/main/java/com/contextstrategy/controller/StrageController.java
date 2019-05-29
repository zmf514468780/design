package com.contextstrategy.controller;

import com.contextstrategy.dao.StragegyDao;
import com.contextstrategy.domain.Stragegy;
import com.contextstrategy.service.PayStrategy;
import com.contextstrategy.utils.SpringUtils;
import com.contextstrategy.utils.StrategyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/21
 **/
@Controller
@RestController
public class StrageController {
    @Autowired
    private StragegyDao stragegyDao;
    @Autowired
    private SpringUtils springUtils;
    @RequestMapping("/test")
    public Object findAll(){
        Stragegy stragegy= stragegyDao.findByChannelId("ali");
        System.out.println(stragegy.getCHANNEL_NAME());
        return stragegyDao.findAll();
    }
    /**
     *@Author zhumf
     *@Description   //  
     *@Date 2019/5/22
     *@Param [map]
     *@return java.lang.Object
    */
    @RequestMapping(value = "/pay",name = "数据库方式调用")
    public Object pay(@RequestParam Map map){
       String payCode =   map.get("payCode").toString();
        Stragegy stragegy=  stragegyDao.findByChannelId(payCode);
        if(stragegy == null){

        }
       String beanName =  stragegy.getStrategy_bean_id();
        PayStrategy payStrategy =    springUtils.getBean(beanName, PayStrategy.class);
        return payStrategy.toPayHtml();
    }
    @RequestMapping(value="/pay2",name="枚举方式调用")
    public Object pay2(@RequestParam Map map) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String payCode =   map.get("payCode").toString();
        PayStrategy payStrategy = StrategyUtils.getPayStrategy(payCode);
        return payStrategy.toPayHtml();
    }
}
