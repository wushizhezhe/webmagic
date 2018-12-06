package com.example.webmagic.task;

import com.example.webmagic.entity.Wechat;
import com.example.webmagic.pipeline.SougouWeixinPipeline;
import com.example.webmagic.processor.SougouPageProcessor;
import com.example.webmagic.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.List;

/**
 * @author czWang
 * @Created 2018/12/6 13:01.
 */
@Component
public class SougouTask {


    private final String URL = "https://weixin.sogou.com/weixin?type=1&s_from=input&query={}&ie=utf8&_sug_=n&_sug_type_=";

    @Autowired
    private WechatService wechatService;

    @Scheduled(fixedDelay = 600000)
    public void task(){
        List<Wechat> select = wechatService.select(new Wechat());
        Spider spider = Spider.create(new SougouPageProcessor())
               // .addUrl("https://weixin.sogou.com/weixin?type=1&s_from=input&query=码农翻身&ie=utf8&_sug_=n&_sug_type_=")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new SougouWeixinPipeline())
                .thread(5);
        select.forEach(w -> {
            spider.addUrl(URL.replace("{}",w.getAccount()));
        });
        spider.run();
    }

}
