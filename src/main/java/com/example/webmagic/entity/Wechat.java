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

    private AppMsgExtInfo appMsgExtInfo;

    private CommMsgInfo commMsgInfo;

    public void setAppMsgExtInfo(AppMsgExtInfo appMsgExtInfo) {
        this.appMsgExtInfo = appMsgExtInfo;
    }

    public AppMsgExtInfo getAppMsgExtInfo() {
        return appMsgExtInfo;
    }

    public void setCommMsgInfo(CommMsgInfo commMsgInfo) {
        this.commMsgInfo = commMsgInfo;
    }

    public CommMsgInfo getCommMsgInfo() {
        return commMsgInfo;
    }

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
