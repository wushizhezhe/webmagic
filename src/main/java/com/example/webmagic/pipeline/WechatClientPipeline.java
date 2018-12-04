package com.example.webmagic.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.example.webmagic.entity.Wechat;
import com.example.webmagic.service.ArticleService;
import com.example.webmagic.service.WechatService;
import com.example.webmagic.util.ToolSpring;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author czWang
 * @Created 2018/12/3 16:46.
 */
public class WechatClientPipeline implements Pipeline {

    private Wechat wechat;

    public WechatClientPipeline() {
    }

    public WechatClientPipeline(Wechat wechat) {
        this.wechat = wechat;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        Object list = resultItems.get("list");
        if (list != null){
            getArticleService().saveByArray((JSONArray) list, wechat.getId());
        }
    }

    public Wechat getWechat() {
        return wechat;
    }

    public void setWechat(Wechat wechat) {
        this.wechat = wechat;
    }


    public WechatService getWechatService() {
        return (WechatService) ToolSpring.getBean("wechatService");
    }

    public ArticleService getArticleService() {
        return (ArticleService) ToolSpring.getBean("articleService");
    }
}
