package com.example.webmagic.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author czWang
 * @Created 2018/12/6 15:32.
 */
public class PicturePageProcess implements PageProcessor {
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";

    Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent(UA_PC);

    @Override
    public void process(Page page) {
        byte[] bytes = page.getBytes();
        String url = page.getUrl().toString();
        page.putField(url,bytes);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
