/**
 * Copyright 2018 bejson.com
 */
package com.example.webmagic.entity;

/**
 * Auto-generated: 2018-12-01 21:3:11
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CommMsgInfo {

    private long datetime;
    private String fakeid;
    private long id;
    private int type;
    private String content;
    private int status;

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setFakeid(String fakeid) {
        this.fakeid = fakeid;
    }

    public String getFakeid() {
        return fakeid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}