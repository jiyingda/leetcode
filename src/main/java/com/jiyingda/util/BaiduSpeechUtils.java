/**
 * @(#)BaiduSpeechUtils.java, 7月 05, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.util;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * 百度语音合成
 * https://ai.baidu.com/ai-doc/SPEECH/uk4nlz4tr
 * @author jiyingdabj
 */
public class BaiduSpeechUtils {
    // per枚举
    //基础： 度小美=0(默认)，度小宇=1，，度逍遥（基础）=3，度丫丫=4
    //精品： 度逍遥（精品）=5003，度小鹿=5118，度博文=106，度小童=110，度小萌=111，度米朵=103，度小娇=5

    public static void main(String[] args) {
        String url = BaiduSpeechUtils.synthesis("今天玩一手，医生姐姐", "5118");
        System.out.println(url);
    }

    private static final String APP_ID = "10542079";
    private static final String API_KEY = "yXkg2veUpMTskZeB9mqyi6SE";
    private static final String SECRET_KEY = "GEKgANwyGw50Q11CF6igWYlWECKobPgI";

    public static String synthesis(String str, String per) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        HashMap<String, Object> options = new HashMap<>();
        options.put("spd", "4");
        options.put("pit", "5");
        options.put("per", per);
        // 调用接口
        TtsResponse res = client.synthesis(str, "zh", 1, options);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        // System.out.println(res1.toString());
        String url = "/Users/jiyingda/test/" + str + System.currentTimeMillis() + ".mp3";
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

}
