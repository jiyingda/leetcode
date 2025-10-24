/**
 * @(#)Test000000.java, 8月 15, 2024.
 * <p>
 * Copyright 2024 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;
import com.jiyingda.util.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class Test000000 {

    /**
     * 云文件的sql 去 https://mario.zhenguanyu.com/#/workbench/sql-query 执行
     * SELECT *
     * FROM ori_mysql_megrez_profile_resource_da
     * WHERE appid = 1
     * 	AND format IN ('jpg', 'png')
     * ORDER BY id DESC
     * LIMIT 10000
     */

    // https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=extraImageOssIdList%20AND%20service%20%3D%20megrez-photo-check&time=4h
    public static void main(String[] args) {


        FileWriter.write("/b/c/a/xwx", "111");

    }
}