/**
 * @(#)Leet1023.java, 4月 14, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 *
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输出：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 *
 * 提示：
 *
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 *
 *
 *
 * @author jiyingda
 */
public class Leet1023 {
    public static void main(String[] args) {
        List<Boolean> s = camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa");
        PrintUtils.printArray(s);
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int left = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) - 'Z' <= 0) {
                if (i - left > 0) {
                    list.add(pattern.substring(left, i));
                }
                list.add("" + pattern.charAt(i));
                left = i + 1;
            }
            i++;
        }
        List<Boolean> r = new ArrayList<>();
        for (String s : queries) {
            int j = 0;
            int l = 0;
            List<String> lllll = new ArrayList<>();
            int y = 0;
            while (j < s.length()) {
                if (s.charAt(j) - 'Z' <= 0) {
                    if (j - l > 0) {
                        lllll.add(s.substring(l, j));
                    }
                    lllll.add("" + s.charAt(j));
                    y++;
                    l = j + 1;
                }
                j++;
            }
            int p = 0;
            int k = 0;
            boolean ffff = true;
            while (k < list.size() && p < lllll.size()) {
                if (list.get(k).charAt(0) - 'Z' <= 0) {
                    if (lllll.get(p).charAt(0) - 'Z' <= 0) {
                        if (list.get(k).charAt(0) == lllll.get(p).charAt(0)) {
                            p++;
                            k++;
                            y--;
                        } else {
                            ffff = false;
                            break;
                        }
                    } else {
                        p++;
                    }
                } else {
                    boolean f = match(lllll.get(p).toCharArray(), list.get(k).toCharArray());
                    if (f) {
                        p++;
                        k++;
                    } else {
                        ffff = false;
                        break;
                    }
                }
            }

            r.add(ffff && (k == list.size()) && y == 0);
        }


        return r;
    }

    private static boolean match(char[] c, char[] s) {
        int i = 0;
        int j = 0;
        while (i < c.length && j < s.length) {
            if (c[i] == s[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == s.length;

    }
}