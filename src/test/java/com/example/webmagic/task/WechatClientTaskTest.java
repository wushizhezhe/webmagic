package com.example.webmagic.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author czWang
 * @Created 2018/12/3 17:41.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatClientTaskTest {

    @Autowired
    private WechatClientTask wechatClientTask;

    @Test
    public void task() {
      wechatClientTask.task();
    }
}