/**
 * @(#)Test1231.java, 12月 31, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.fenbi.common.util.JsonUtils;

/**
 * @author jiyingdabj
 */
public class Test1231 {

    public static void main(String[] args) {
        // System.out.println(getSystemPrompt());

        String ss = "xujiaxingsy\n" +
                "jinmingsy02\n" +
                "lichunyusy\n" +
                "liangjingtongsy \n" +
                "wanghuida\n" +
                "lichenghaosy\n" +
                "wanglaijia\n" +
                "zhaolisy02\n" +
                "wangzhilinsy02\n" +
                "tanyawensy03\n" +
                "niehuaichuansy\n" +
                "zhangyiwensy04\n" +
                "wangyuanbosy\n" +
                "jiangdiankuisy\n" +
                "guoliangsy\n" +
                "masiyusy03\n" +
                "yangyangsy23\n" +
                "jinziyangsy\n" +
                "liudijia\n" +
                "wangchangsy04\n" +
                "zhaoyajuansy";

       String[] sss = ss.split("\n");
       for (String ssssss : sss) {
           System.out.print("'" + ssssss + "',");
       }
       // System.out.println(JsonUtils.writeValue(sss));

    }

}