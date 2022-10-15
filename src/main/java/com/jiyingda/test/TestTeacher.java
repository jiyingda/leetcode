/**
 * @(#)TestTeacher.java, 5月 06, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class TestTeacher {

    public static void main(String[] args) {
        String s = "119\t3年教龄\t30\t5\t1\t1426822301000\n" +
                "121\t4年教龄\t31\t5\t1\t1426822301000\n" +
                "123\t5年教龄\t32\t5\t1\t1426822301000\n" +
                "125\t6年教龄\t33\t5\t1\t1426822301000\n" +
                "127\t7年教龄\t34\t5\t1\t1426822301000\n" +
                "129\t8年教龄\t35\t5\t1\t1426822301000\n" +
                "131\t9年教龄\t36\t5\t1\t1426822301000\n" +
                "133\t10年教龄\t37\t5\t1\t1426822301000\n" +
                "135\t11年教龄\t38\t5\t1\t1426822301000\n" +
                "137\t12年教龄\t39\t5\t1\t1426822301000\n" +
                "139\t13年教龄\t40\t5\t1\t1426822301000\n" +
                "141\t14年教龄\t41\t5\t1\t1426822301000\n" +
                "143\t15年教龄\t42\t5\t1\t1426822301000\n" +
                "145\t16年教龄\t43\t5\t1\t1426822301000\n" +
                "147\t17年教龄\t44\t5\t1\t1426822301000\n" +
                "149\t18年教龄\t45\t5\t1\t1426822301000\n" +
                "151\t19年教龄\t46\t5\t1\t1426822301000\n" +
                "153\t20年教龄\t47\t5\t1\t1426822301000\n" +
                "155\t21年教龄\t48\t5\t1\t1426822301000\n" +
                "157\t22年教龄\t49\t5\t1\t1426822301000\n" +
                "159\t23年教龄\t50\t5\t1\t1426822301000\n" +
                "161\t24年教龄\t51\t5\t1\t1426822301000\n" +
                "163\t25年教龄\t52\t5\t1\t1426822301000\n" +
                "165\t26年教龄\t53\t5\t1\t1426822301000\n" +
                "167\t27年教龄\t54\t5\t1\t1426822301000\n" +
                "169\t28年教龄\t55\t5\t1\t1426822301000\n" +
                "171\t29年教龄\t56\t5\t1\t1426822301000\n" +
                "173\t30年教龄\t57\t5\t1\t1426822301000";
        String[] ss = s.split("\n");
        int i = 3;
        for (String ssss : ss) {
            String[] id = ssss.split("\t");;
            String sql = "update label set name = '" + i + "年教学经验' where id = " + id[0] + ";";
            System.out.println(sql);
            i++;
        }
    }
}