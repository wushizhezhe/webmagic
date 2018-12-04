package com.example.webmagic.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.example.webmagic.entity.Wechat;
import com.example.webmagic.service.ArticleService;
import com.example.webmagic.service.WechatService;
import com.example.webmagic.util.ToolSpring;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * Created by 83501 on 2018/12/1.
 */
public class SougouWeixinPipeline implements Pipeline {

   // Logger logger = LoggerFactory.getLogger(SougouWeixinPipeline.class);

    @Override
    public void process(ResultItems resultItems, Task task) {

        Map<String, Object> all = resultItems.getAll();
        String spiderType = (String) all.get("spiderType");
        if (spiderType.equals("wechatInfo")){
            Wechat wechat = (Wechat) all.get("wechat");
            JSONArray list = (JSONArray) all.get("list");
            getWechatService().insert(wechat);
            getArticleService().saveByArray(list,wechat.getId());
        }
    }

    public WechatService getWechatService() {
        return (WechatService) ToolSpring.getBean("wechatService");
    }

    public ArticleService getArticleService() {
        return (ArticleService) ToolSpring.getBean("articleService");
    }
}
