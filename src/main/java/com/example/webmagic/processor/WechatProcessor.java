package com.example.webmagic.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czWang
 * @Created 2018/12/3 14:48.
 */
public class WechatProcessor implements PageProcessor {
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent(UA_PC);

    String[] replace = {"&#39;", "'", "&quot;", "\"", "&nbsp;", " ", "&gt;", ">", "&lt;", "<", "&yen;", "¥", "&amp;", "&"};

    @Override
    public void process(Page page) {

        String url = page.getUrl().toString();
        String html = page.getHtml().toString();
        if (html.contains("没权")){
            return;
        }
        System.out.println(html);
/*        String substring = html.substring(html.indexOf("msgList = '") + 11, html.indexOf("}]}';") + 3);
        String json = resolveJson(substring);
        System.out.println(json);
        JSONObject parse = (JSONObject) JSON.parse(json);*/
        Map<String, String> params = url2Map(url);
        String nextUrl = null;
        if (url.contains("action=home")) {
            //首页处理
            String substring = html.substring(html.indexOf("window.appmsg_token ="));
            String[] split = substring.split("\"");
            params.put("appmsg_token", split[1]);
            nextUrl = resolveJson(params, 0);
        } else if (url.contains("action=getmsg")) {

            //String nextUrl = resolveJson(params, 0);
            Json json = page.getJson();
            String jsonFirstSourceText = json.getFirstSourceText();
            JSONObject parse = (JSONObject) JSON.parse(jsonFirstSourceText);
            String generalMsgList = parse.getString("general_msg_list");
            JSONObject generalMsgListJson = (JSONObject) JSON.parse(generalMsgList);
            JSONArray list = generalMsgListJson.getJSONArray("list");
            page.putField("list",list);
            if (list.size() == 10){
                int offse = Integer.valueOf(params.get("offset")) + 10;
                nextUrl = resolveJson(params, offse);
            }

            System.out.println(parse);
        }
        if (nextUrl != null){
            page.addTargetRequest(nextUrl);
        }
    }


    private Map<String, String> url2Map(String url) {
        Map<String, String> result = new HashMap<>();
        url = url.substring(url.indexOf("?") + 1, url.length() - 1);
        String[] params = url.split("&");
        for (String param : params) {

            int index = param.indexOf("=");
            String key = param.substring(0, param.indexOf("="));
            String value;
            if (index == param.length() - 1) {
                value = "";
            } else {
                value = param.substring(param.indexOf("=") + 1, param.length());
            }
            result.put(key, value);
        }
        return result;
    }


    private String resolveJson(String s) {
        for (int i = 0; i < replace.length; i += 2) {
            s = s.replace(replace[i], replace[i + 1]);
        }
        return s;
    }

    @Override
    public Site getSite() {
        return site;
    }

    private String resolveJson(Map<String, String> params, int offset) {
        String urlJson =
                "https://mp.weixin.qq.com/mp/profile_ext?action=getmsg&__biz=" + params.get("__biz")
                        + "&f=json&offset=" + offset + "&count=10&is_ok=1&scene=124&uin=" + params.get("uin")
                        + "&key=" + params.get("key") + "&pass_ticket=" + params.get("pass_ticket")
                        + "&wxtoken=&appmsg_token=" + params.get("appmsg_token") + "&f=json";
        return urlJson;

    }


    public static void main(String[] args) {
        String url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzA3MDI2MjIzNw==&scene=124&uin=MTQ4NjM1MzM4MQ%3D%3D&key=65c24659e92154d950ab62974b012291094e53be2637fe528c6f54fbdb2e9f2d2520d89d3dcc01a0de0a5903f4373f8ea8d93e857659b699fd939f4f7d893aff31d049524e33cea44105366b3932409e&devicetype=Windows+10&version=62060619&lang=zh_CN&a8scene=7&pass_ticket=IP%2By%2BvQ5kvnV%2F9jB5ou88GtQ5O3RLfIF0gxcs16e9HClm2VGqqdqUMXR5vQJJrZI&winzoom=1";

        Spider.create(new WechatProcessor())
                .addUrl(url)
                .addPipeline(new ConsolePipeline())
                .run();
    }
}
