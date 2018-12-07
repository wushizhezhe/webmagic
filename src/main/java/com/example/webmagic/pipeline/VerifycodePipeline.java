package com.example.webmagic.pipeline;

import com.example.webmagic.processor.PicturePageProcess;
import com.example.webmagic.util.FileUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * @author czWang
 * @Created 2018/12/6 15:47.
 */
public class VerifycodePipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> all = resultItems.getAll();
        all.forEach((k,v) -> {
            String cert = getCert(k) + ".jpg";
            FileUtil.byte2File((byte[]) v,cert);
        });
    }

    private String getCert(String url){
        return url.substring(url.indexOf("=") + 1,url.length());
    }

    public static void main(String[] args) {
        /*VerifycodePipeline t = new VerifycodePipeline();
        String url = "http://mp.weixin.qq.com/mp/verifycode?cert=1544077339602.3474";
        System.out.println(t.getCert(url));*/
        Spider.create(new PicturePageProcess())
                .addPipeline(new VerifycodePipeline())
                .addPipeline(new ConsolePipeline())
                .addUrl("http://mp.weixin.qq.com/mp/verifycode?cert=1544083564112.6099")
                .run();
    }
}
