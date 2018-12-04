package com.example.webmagic.dao;

import com.example.webmagic.entity.SpiderTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpiderTaskDao {

    int insert(@Param("pojo") SpiderTask pojo);

    int insertList(@Param("pojos") List< SpiderTask> pojo);

    List<SpiderTask> select(@Param("pojo") SpiderTask pojo);

    int update(@Param("pojo") SpiderTask pojo);

}
