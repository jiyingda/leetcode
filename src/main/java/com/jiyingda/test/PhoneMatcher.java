/**
 * @(#)PhoneMatcher.java, 1月 12, 2026.
 * <p>
 * Copyright 2026 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jiyingdabj
 */
public class PhoneMatcher {

    // 严格验证手机号
    public static boolean isValidPhone(String phone) {
        String pattern = "^1[3-9]\\d{9}$"; // Java中\需转义为\\
        return Pattern.matches(pattern, phone);
    }

    // 提取文本中的手机号
    public static void extractPhones(String text) {
        String pattern = "1[3-9]\\d{9}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("提取到手机号：" + m.group());
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidPhone("13812345678")); // true
        extractPhones("客服电话：10086（无效），个人电话：13900000000");
        // 输出：提取到手机号：13900000000
    }
}