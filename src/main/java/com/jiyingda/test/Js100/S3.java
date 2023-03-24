/**
 * @(#)S3.java, 3月 18, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.Js100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiyingda
 */
public class S3 {
    public static void main(String[] args) {
        int[] nn = new int[]{2,1};
        long k = findScore(nn);
        System.out.print(k);

    }

    public static long findScore(int[] nums) {
        PriorityQueue<A> queue = new PriorityQueue<>(((e1, e2) -> {
            if (e1.v == e2.v) {
                return e1.idx - e2.idx;
            }
            return e1.v - e2.v;
        }));
        int[] bj = new int[nums.length];
        int s = nums.length;
        for (int i = 0; i < nums.length; i++) {
            queue.add(new A(nums[i], i));
        }
        long score = 0;
        while (s >= 0 && !queue.isEmpty()) {
            A a = queue.poll();
            if (bj[a.idx] == 1) {
                continue;
            }
            score += a.v;
            bj[a.idx] = 1;
            s--;
            int j = a.idx;
            if (j - 1 >= 0 && bj[j - 1] == 0) {
                bj[j - 1] = 1;
                s--;
            }
            if (j + 1 < nums.length && bj[j + 1] == 0) {
                bj[j + 1] = 1;
                s--;
            }
        }

        return score;
    }

    static class A {
        int v;
        int idx;

        public A(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }
}