/**
 * @(#)M1711.java, 3月 18, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.ms;

/**
 * @author jiyingdabj
 */
public class M1711 {

    public static void main(String[] args) {
        String[] ss = new String[]{"I","am","a","student","from","a","university","in","a","city"};
        findClosest(ss, "am", "student");
    }


    public static int findClosest(String[] words, String word1, String word2) {
        int min = words.length;
        int idx = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2) ) {
                if (idx == -1) {
                    idx = i;
                } else {
                    if (!words[i].equals(words[idx])) {
                        min = Math.min(min, i - idx);
                        idx = i;
                    } else {
                        idx = i;
                    }

                }
            }

        }
        return min;
    }
}
