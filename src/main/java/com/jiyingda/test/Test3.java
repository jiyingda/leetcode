/**
 * @(#)Test3.java, 8月 17, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.FileReader;
import com.jiyingda.util.FileWriter;
import com.jiyingda.util.PrintUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jiyingdabj
 */
public class Test3 {

    static String FizzBuzz = "FizzBuzz";
    static String Fizz = "Fizz";
    static String Buzz = "Buzz";
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean i3 = i % 3 == 0;
            boolean i5 = i % 5 == 0;
            if (i3 && i5) {
                list.add(FizzBuzz);
            } else if (i3) {
                list.add(Fizz);
            } else if (i5) {
                list.add(Buzz);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;

    }

    public static final int STUDY = 1;
    public static final int EXAM_A = 2;
    public static final int EXAM_B = 3;

    public static int nextExamType() {
        Random random = new Random();
        return random.nextInt(2) == 0 ? EXAM_A : EXAM_B;
    }

    public static void main(String[] args) {

        List<String> list = FileReader.readFromVs("asearch");
        for (int i = 500; i < 10500; i++) {
            System.out.print("\"" + list.get(i) + "\",");
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] cc = s.toCharArray();
            Arrays.sort(cc);
            String key = new String(cc);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        List<List<String>> r = new ArrayList<>();
        r.addAll(map.values());
        return r;
    }
}
