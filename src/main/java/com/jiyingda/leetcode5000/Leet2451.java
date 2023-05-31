/**
 * @(#)Leet2451.java, 5月 25, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingda
 */
public class Leet2451 {
    public static void main(String[] args) {
        String[] s = new String[]{"abm","bcn","alm"};
        Leet2451 leet2451 = new Leet2451();
        System.out.print(leet2451.oddString(s));;

    }

    public String oddString(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        int j = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < words[0].length(); i++) {
                sb.append(word.charAt(i) - word.charAt(i - 1)).append("-");
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> ss = new ArrayList<>();
                ss.add(word);
                map.put(key, ss);
                if (map.size() >= 2 && j > 1) {
                    return map.entrySet().stream().filter(e -> e.getValue().size() == 1).findFirst().get().getValue().get(0);
                }
            }
            j++;
        }
        return map.entrySet().stream().filter(e -> e.getValue().size() == 1).findFirst().get().getValue().get(0);
    }
}