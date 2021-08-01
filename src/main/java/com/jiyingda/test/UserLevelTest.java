/**
 * @(#)UserLevelTest.java, 7月 13, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiyingda
 */
public class UserLevelTest {

    public static void main1(String[] args) {
        long userId = 172190049L;
        System.out.println((userId & 0xF) >> 3);
        System.out.println((userId & 0xF) >> 1);

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int i = 0;
        for (Integer a : list) {
            System.out.println(a);
            list.set(i, 0);
            i++;
        }
        list.clear();
        System.out.println(list);
    }

    public static void main3(String[] args) {
        long userId = 329383600L;
        System.out.println((userId & 0xFF) >> 5);
        System.out.println((userId & 0xFF) >> 1);
    }

    public static void main2(String[] args) {
        int j = 0;
        System.out.println("tutor_profile_shard" + 0);
        for (int i = 0; i < 128; i++) {
            String s = "delete from student_level_" + i + " where id > 0;";
            System.out.println(s);
            if ((i+1) % 16 == 0) {
                j++;
                System.out.println("tutor_profile_shard" + j);

            }
         }
    }

    public static List<Integer> list = new ArrayList<>();

    public static void main444(String[] args) {
        int retryNum = Math.max(Math.min(-1, 10), 1);
        System.out.println(retryNum);
        String s ="update student_level_0 set disabled = false where id between 5000 and 10000 and subjectId = 3 and productLineId = 3 and disabled = true and updatedTime > 1611763200000;";

    }

    public static void main(String[] args) {
        int j = 0;
        System.out.println("tutor-profile-sharding-" + 0 + "-mysql-writer");
        for (int i = 0; i < 128; i++) {

                String s ="update student_level_" + i + " set disabled = false where subjectId = 3 and productLineId = 3 and disabled = true and updatedTime > 1611763200000;";
            System.out.println(s);


            if ((i+1) % 16 == 0) {
                j++;
                System.out.println("tutor-profile-sharding-" + j + "-mysql-writer");

            }
         }
    }

}