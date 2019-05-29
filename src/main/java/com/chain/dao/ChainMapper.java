package com.chain.dao;

import com.chain.domain.GatewayHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/23
 **/
@Mapper
public interface ChainMapper {
    @Select("select * from gateway_handler")
    List<GatewayHandler>  findAll();

    @Select("select * from gateway_handler where prev_handler_id is   null")
    GatewayHandler getFirstHandler();
    @Select("select * from gateway_handler where handler_id =  #{prev_handler_id}")
    GatewayHandler getHandler(String prev_handler_id);
}
