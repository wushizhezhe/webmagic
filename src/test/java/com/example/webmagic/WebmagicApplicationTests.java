package com.example.webmagic;

import com.example.webmagic.pipeline.SougouWeixinPipeline;
import com.example.webmagic.processor.SougouPageProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebmagicApplicationTests {

    @Test
    public void contextLoads() {

        Spider.create(new SougouPageProcessor())
                .addUrl("https://weixin.sogou.com/weixin?type=1&s_from=input&query=码农翻身&ie=utf8&_sug_=n&_sug_type_=")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new SougouWeixinPipeline())
                .thread(5).run();
    }

}
