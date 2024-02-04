/**
 * @(#)StreamRank.java, 3月 23, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.ms;

/**
 * @author jiyingdabj
 */
public class StreamRank {
    int[] nums;
    public StreamRank() {
        nums = new int[50001];
    }

    public void track(int x) {
        nums[x]++;
    }

    public int getRankOfNumber(int x) {
        int all = 0;
        for (int i = 0; i <= x; i++) {
            all += nums[i];
        }
        return all;
    }
}
