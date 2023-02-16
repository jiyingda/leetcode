/**
 * @(#)StudentAppLoginInfo.java, 8月 23, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingda
 */
public class StudentAppLoginInfo {
    /*
    * @RequestParam("_hostProductId") int hostProductId,
            @RequestParam("_productId") int productId,
            @RequestParam(value = "UDID", defaultValue = "") String UDID,
            @RequestParam(value = "YFD_U", defaultValue = "") String YFD_U,
            @RequestParam(value = "version", defaultValue = "unknown") String version,
            @RequestParam(value = "hostVersion", defaultValue = "unknown") String hostVersion,
            @RequestParam(value = "model", defaultValue = "unknown") String model,
            @RequestParam(value = "network", defaultValue = "unknown") String network,
            @RequestParam(value = "platform", defaultValue = "unknown") String platform,
            @RequestParam(value = "engineVersion", defaultValue = "unknown") String engineVersion,
    * */

    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        set.add("_hostProductId");
        set.add("_productId");
        set.add("UDID");
        set.add("YFD_U");
        set.add("version");
        set.add("hostVersion");
        set.add("model");
        set.add("network");
        set.add("platform");
        set.add("engineVersion");
        set.add("@__user_id__");
        File preTimeFile = new File("/Users/jiyingda/vscode/studentAppLoginInfo");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            JSONArray arrag = new JSONArray();
            List<String> reList = new ArrayList<>();
            String url = "_debug_user_=%s&_hostProductId=%s&_productId=%s&YFD_U=%s&version=%s&hostVersion=%s&model=%s&network=%s&platform=%s&engineVersion=%s";
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                JSONObject obj = new JSONObject();
                for (String ss : array) {
                    String[] s = ss.split("=");
                    if (set.contains(s[0])) {
                        obj.put(s[0], s[1]);
                    }
                }
                reList.add(String.format(url, obj.getString("@__user_id__")
                        ,obj.getString("_hostProductId"),obj.getString("_productId")
                        ,obj.getString("YFD_U"),obj.getString("version")
                        ,obj.getString("hostVersion"),obj.getString("model")
                        ,obj.getString("network"),obj.getString("platform")
                        ,obj.getString("engineVersion")));


            }





            // https://ke.yuanfudao.biz/tutor-student-app/api/users/current/summary?_hostProductId=374&_debug_ldap_=Gatling&_debug_user_=${userIdCsv}
            Files.write(Paths.get("/Users/jiyingda/vscode/studentAppLoginInfoOut"), reList);
        }
    }
}