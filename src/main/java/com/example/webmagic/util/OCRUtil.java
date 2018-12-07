package com.example.webmagic.util;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author czWang
 * @Created 2018/12/6 14:26.
 */
public class OCRUtil {


    //设置APPID/AK/SK
    public static final String APP_ID = "14681417";
    public static final String API_KEY = "XhLK3HA39PkZehXMXvCf4M1r";
    public static final String SECRET_KEY = "yoTonAnsVgpVVi27ww76GlBon5kD1Aho";

    private static AipOcr client;

    static {
        init();
    }

    public static void init(){
        // 初始化一个AipOcr
        client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        // client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
    }

    public void test() throws JSONException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        // 调用接口
        String path = "C:\\Users\\Administrator\\Pictures\\timg.jpg";
        for (int i = 0; i < 10; i++) {
            JSONObject res = client.basicGeneral(path, options);
            System.out.println(res.toString(2));
        }
        JSONObject res = client.basicGeneral(path, options);
        System.out.println(res.toString(2));

    }

}
