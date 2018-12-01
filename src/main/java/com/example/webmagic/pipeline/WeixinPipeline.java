package com.example.webmagic.pipeline;

import com.example.webmagic.entity.Wechat;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * Created by 83501 on 2018/12/1.
 */
public class WeixinPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> all = resultItems.getAll();
        Wechat wechat = (Wechat) all.get("wechat");
        Object list = all.get("list");
    }
}
