package com.example.webmagic.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * @author czWang
 * @Created 2018/12/4 13:34.
 */
public class BaitenPageProcessor implements PageProcessor {
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent(UA_PC);


    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        System.out.println(html.toString());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new BaitenPageProcessor())
                .addUrl("https://www.patexplorer.com/results/s.html?sc=63&q=pa:(广州军区总医院) &fq=&type=s&sort=&sortField=")
                .run();
    }
}
