package com.example.webmagic.entity.dto;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czWang
 * @Created 2018/12/4 14:16.
 */
public class BaseDTO {

    private String keywords;
    private Integer onPage;
    private Integer toPage;
    private List<String> sort;
    private Integer pageNum;
    private Integer pageSize;

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 1000 : pageSize;
    }

    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }

    public Integer getOnPage() {

        return getPageNum() * getPageSize() - getPageSize();
    }

    public Integer getToPage() {
        return getPageSize();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public void addSort(String sort) {
        if (CollectionUtils.isEmpty(this.sort)) {
            this.sort = new ArrayList<>();
        }
        this.sort.add(sort);
    }

    public void clearSort() {
        this.sort = new ArrayList<>();
    }
}
