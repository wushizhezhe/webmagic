package com.example.webmagic.dao;

import com.example.webmagic.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    int insert(@Param("pojo") Article pojo);

    int insertList(@Param("pojos") List< Article> pojo);

    List<Article> select(@Param("pojo") Article pojo);

    List<Article> selectByOriginalId(Long originalId);

    int update(@Param("pojo") Article pojo);

}
