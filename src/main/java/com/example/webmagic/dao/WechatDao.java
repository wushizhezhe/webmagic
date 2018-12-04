package com.example.webmagic.dao;

import com.example.webmagic.entity.Wechat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatDao {

    int insert(@Param("pojo") Wechat pojo);

    int insertList(@Param("pojos") List< Wechat> pojo);

    List<Wechat> select(@Param("pojo") Wechat pojo);

    int update(@Param("pojo") Wechat pojo);

}
