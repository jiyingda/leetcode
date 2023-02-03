/**
 * @(#)T2.java, 1月 03, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingdabj
 */
public class T2 {

    public static void main(String[] args) {
        String s = "123456789012345678901";
        System.out.println(checkContentLength(s));


    }

    private static String checkContentLength(String content) {
        if (content == null) {
            return "";
        }
        if (content.length() <= 20) {
            return content;
        }
        return content.substring(0, 16) + "...";
    }
}
