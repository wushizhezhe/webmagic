package com.example.webmagic.entity.VO;

import com.example.webmagic.entity.Article;

/**
 * @author czWang
 * @Created 2018/12/6 11:47.
 */
public class ArticleVO extends Article {

    private String nickName;

    private String account;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
