/**
 * @(#)Utils.java, 10月 14, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class Utils {

    // 1. 构建拼音-汉字映射（从用户提供的列表中提取有效映射，此处简化示例）
    private static final Map<String, String> PINYIN_HANZI_MAP;
    // 2. 按拼音长度降序排序的拼音列表（核心：优先匹配长拼音）
    private static final List<String> SORTED_PINYINS;

    static {
        // 初始化映射表（仅示例，实际需导入用户提供的完整列表）
        PINYIN_HANZI_MAP = new HashMap<>();
        PINYIN_HANZI_MAP.put("lǒu", "搂"); // 匹配用户输入的“lōu”（声调偏差修正）
        PINYIN_HANZI_MAP.put("nǐ", "你");
        PINYIN_HANZI_MAP.put("hǎo", "好");
        PINYIN_HANZI_MAP.put("hā", "哈");

        // 按拼音长度降序排序（长拼音先匹配）
        SORTED_PINYINS = new ArrayList<>(PINYIN_HANZI_MAP.keySet());
        SORTED_PINYINS.sort((p1, p2) -> Integer.compare(p2.length(), p1.length()));
    }

    // 核心替换方法
    public String replacePinyinWithHanzi(String content) {
        StringBuilder result = new StringBuilder();
        int len = content.length();
        int i = 0;

        while (i < len) {
            char c = content.charAt(i);
            // 判断当前字符是否为拼音字符（a-z、A-Z、带声调的拼音字符，此处简化为“非中文字符则视为拼音片段起始”）
            if (isPinyinChar(c)) {
                // 尝试匹配最长的拼音（从SORTED_PINYINS中遍历）
                boolean matched = false;
                for (String pinyin : SORTED_PINYINS) {
                    int pinyinLen = pinyin.length();
                    // 检查当前位置开始是否能匹配该拼音（需处理大小写/声调偏差，此处简化）
                    if (i + pinyinLen <= len && content.substring(i, i + pinyinLen).equalsIgnoreCase(pinyin)) {
                        // 匹配成功，替换为汉字
                        result.append(PINYIN_HANZI_MAP.get(pinyin));
                        i += pinyinLen; // 跳过已匹配的拼音字符
                        matched = true;
                        break; // 长拼音已匹配，无需再试短拼音
                    }
                }
                // 若未匹配到任何拼音，直接保留原字符
                if (!matched) {
                    result.append(c);
                    i++;
                }
            } else {
                // 中文字符直接保留
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }

    // 辅助方法：判断字符是否为拼音相关字符（简化版，实际需支持带声调的Unicode拼音字符）
    private boolean isPinyinChar(char c) {
        // 匹配a-z、A-Z，及带声调的拼音字符（如ō、ǔ等，Unicode范围：U+00C0-U+017F）
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 0xC0 && c <= 0x17F);
    }

}