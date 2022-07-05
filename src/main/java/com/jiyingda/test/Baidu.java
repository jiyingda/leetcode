/**
 * @(#)Baidu.java, 7月 05, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author jiyingdabj
 */
public class Baidu {



        //设置APPID/AK/SK
        public static final String APP_ID = "10542079";
        public static final String API_KEY = "yXkg2veUpMTskZeB9mqyi6SE";
        public static final String SECRET_KEY = "GEKgANwyGw50Q11CF6igWYlWECKobPgI";

        public static void main(String[] args) {
            // 初始化一个AipSpeech
            AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);

            // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
            //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
            //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

            // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
            // 也可以直接通过jvm启动参数设置此环境变量
            System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

            HashMap<String, Object> options = new HashMap<String, Object>();
            options.put("spd", "5");
            options.put("pit", "5");
            options.put("per", "111");
            // 调用接口
            TtsResponse res = client.synthesis("医生姐姐来了", "zh", 1, options);
            byte[] data = res.getData();
            JSONObject res1 = res.getResult();
            if (data != null) {
                try {
                    Util.writeBytesToFileSystem(data, "/Users/jiyingda/test/医生姐姐来了.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (res1 != null) {
                System.out.println(res1.toString(2));
            }

        }

}
