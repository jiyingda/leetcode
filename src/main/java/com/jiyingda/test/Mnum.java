/**
 * @(#)Mnum.java, 9月 11, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class Mnum {

    public static void main(String[] args) {
        //System.out.println(numOfDifferentGameProcesses(1));
        System.out.println(numOfFirstWin(10));
        // print 45
    }

    public static int numOfDifferentGameProcesses(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            return dp[1];
        }
        dp[2] = 2;
        if (n == 2) {
            return dp[2];
        }
        int i = 3;
        while (i <= n) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }
        return dp[n];
    }

    public static int numOfFirstWin(int n) {
        int[] firstDp = new int[n + 1];
        int[] secondDp = new int[n + 1];
        firstDp[1] = 1;
        secondDp[1] = 0;
        if (n == 1) {
            return firstDp[1];
        }
        firstDp[2] = 1;
        secondDp[2] = 1;
        if (n == 2) {
            return firstDp[2];
        }
        int i = 3;
        while (i <= n) {
            firstDp[i] = secondDp[i - 1] + secondDp[i - 2];
            secondDp[i] = firstDp[i - 1] + firstDp[i - 2];
            i++;
        }
        return firstDp[n];
    }
}
