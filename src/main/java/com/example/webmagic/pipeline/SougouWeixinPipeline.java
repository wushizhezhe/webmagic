package com.example.webmagic.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.example.webmagic.entity.Wechat;
import com.example.webmagic.service.ArticleService;
import com.example.webmagic.service.WechatService;
import com.example.webmagic.util.ToolSpring;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
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
            List<Wechat> select = getWechatService().select(new Wechat(wechat.getAccount()));
            if (!select.isEmpty()){
                wechat.setId(select.get(0).getId());
                getWechatService().update(wechat);
            }else {
                getWechatService().insert(wechat);
            }
            JSONArray list = (JSONArray) all.get("list");
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
