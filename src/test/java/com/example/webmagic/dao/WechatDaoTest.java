package com.example.webmagic.dao;

import com.example.webmagic.entity.Wechat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author czWang
 * @Created 2018/12/3 11:31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatDaoTest {

    @Autowired
    private WechatDao wechatDao;


    @Test
    public void insert() {
        Wechat wechat = new Wechat();
        wechat.setNickName("test");
        wechatDao.insert(wechat);
    }

    @Test
    public void insertList() {
    }

    @Test
    public void select() {
    }

    @Test
    public void update() {
    }
}