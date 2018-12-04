package com.example.webmagic.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.webmagic.entity.Wechat;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author czWang
 * @Created 2018/11/30 15:30.
 */
public class SougouPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        String url = page.getUrl().toString();
        if(url.contains("https://weixin.sogou.com/weixin?type=1")){

            List<String> all = page.getHtml().links().regex("http://mp\\.weixin\\.qq\\.com/profile\\?src=3.*").all();

            //System.out.println("size:" + all.size());
           // Set<String> set = new HashSet<>(all);
            //set.forEach(System.out::println);
            page.putField("spiderType", "wechat");
            page.addTargetRequest(all.get(0));
        }

        if (url.contains("http://mp.weixin.qq.com/profile?src=3")){
            page.putField("spiderType", "wechatInfo");
            Html html = page.getHtml();
            System.out.println(html.toString());
            Selectable nickName = page.getHtml().$("strong.profile_nickname","text");
           // System.out.println("nickName:" + nickName);
           // page.putField("nick",nickName);
            Wechat wechat = new Wechat();
            wechat.setNickName(nickName.toString().trim());
            wechat.setSourceUrl(url);
            String info = page.getHtml().$(".profile_desc .profile_desc_value", "text").toString().trim();
            String account = page.getHtml().$(".profile_account", "text").toString();
            account = account.replace("微信号:", "").trim();
            wechat.setAccount(account);
            wechat.setInfo(info);
            page.putField("wechat",wechat);

            String  shtml = html.toString();
            String substring = shtml.substring(shtml.indexOf("msgList =") + 10, shtml.indexOf("}]};") + 3);
           // System.out.println(substring);
            JSONObject jsonObject = JSON.parseObject(substring);
            System.out.println(jsonObject);
            page.putField("list",jsonObject.get("list"));
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

    }
}
