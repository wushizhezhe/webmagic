package com.example.webmagic.entity;

/**
 * @author czWang
 * @Created 2018/11/30 17:13.
 */
public class Wechat {

    private Integer id;

    private String nickName;

    private String info;

    private String account;

    private String sourceUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Wechat(String account) {
        this.account = account;
    }

    public Wechat() {
    }

    @Override
    public String toString() {
        return "Wechat{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", info='" + info + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
