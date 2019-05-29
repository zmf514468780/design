package com.contextstrategy.dao;

import com.contextstrategy.domain.Stragegy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * @Description TODO
 * @Author zhumf
 * @Date 2019/5/21
 **/
@Mapper
public interface StragegyDao {
    @Select("select  * from  payment_channel")
    List<Stragegy> findAll();
    @Select("select  * from  payment_channel where CHANNEL_ID = #{channelId}")
    Stragegy  findByChannelId(String channelId);
}
