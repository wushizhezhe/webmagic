package com.example.webmagic.task;

import com.example.webmagic.entity.SpiderTask;
import com.example.webmagic.entity.Wechat;
import com.example.webmagic.pipeline.WechatClientPipeline;
import com.example.webmagic.processor.WechatProcessor;
import com.example.webmagic.service.SpiderTaskService;
import com.example.webmagic.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.Date;
import java.util.List;

/**
 * @author czWang
 * @Created 2018/12/3 17:06.
 */
@Component
public class WechatClientTask {



    @Autowired
    private SpiderTaskService spiderTaskService;

    @Autowired
    private WechatService wechatService;

    @Scheduled(fixedDelay = 60000)
    public void task(){
        SpiderTask pojo = new SpiderTask();
        pojo.setStatus(0);
        List<SpiderTask> select = spiderTaskService.select(pojo);
        for (SpiderTask spiderTask : select) {
            String account = spiderTask.getAccount();
            Wechat wechat = new Wechat();
            wechat.setAccount(account);
            List<Wechat> wechats = wechatService.select(wechat);
            if (wechats != null && wechats.size() > 0){
                wechat = wechats.get(0);
            }else {
                wechat.setNickName(spiderTask.getName());
                wechatService.insert(wechat);
            }


            Spider.create(new WechatProcessor())
                    .addPipeline(new ConsolePipeline())
                    .addPipeline(new WechatClientPipeline(wechat))
                    .addUrl(spiderTask.getUrl())
                    .thread(1).run();
            spiderTask.setStatus(1);
            spiderTask.setFinishTime(new Date());
            spiderTaskService.update(spiderTask);
        }

    }

}
