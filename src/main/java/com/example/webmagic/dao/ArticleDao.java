package com.example.webmagic.dao;

import com.example.webmagic.entity.Article;
import com.example.webmagic.entity.VO.ArticleVO;
import com.example.webmagic.entity.dto.BaseDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    int insert(@Param("pojo") Article pojo);

    int insertList(@Param("pojos") List< Article> pojo);

    List<Article> select(@Param("pojo") Article pojo);

    List<Article> selectByOriginalId(Long originalId);

    int update(@Param("pojo") Article pojo);

    List<ArticleVO> selectPage(BaseDTO dto);

    int selectPageTotal();

    int delete(Integer id);
}
