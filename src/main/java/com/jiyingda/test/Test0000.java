/**
 * @(#)Test0000.java, 9月 12, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author jiyingdabj
 */
public class Test0000 {

    public static void main(String[] args) {
        long a = getDaysBetween("20230901", "20230831");
        System.out.println(a);
    }

    public static long getDaysBetween(String today, String registerDay) {
        LocalDate l1 = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate l2 = LocalDate.parse(registerDay, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return ChronoUnit.DAYS.between(l1, l2);
    }
}
