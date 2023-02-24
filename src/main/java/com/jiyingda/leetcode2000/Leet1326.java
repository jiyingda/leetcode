/**
 * @(#)Leet1326.java, 2月 23, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 *
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 *
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 *
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 5, ranges = [3,4,1,1,0,0]
 * 输出：1
 * 解释：
 * 点 0 处的水龙头可以灌溉区间 [-3,3]
 * 点 1 处的水龙头可以灌溉区间 [-3,5]
 * 点 2 处的水龙头可以灌溉区间 [1,3]
 * 点 3 处的水龙头可以灌溉区间 [2,4]
 * 点 4 处的水龙头可以灌溉区间 [4,4]
 * 点 5 处的水龙头可以灌溉区间 [5,5]
 * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
 * 示例 2：
 *
 * 输入：n = 3, ranges = [0,0,0,0]
 * 输出：-1
 * 解释：即使打开所有水龙头，你也无法灌溉整个花园。
 *
 *
 * 提示：
 *
 * 1 <= n <= 104
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 *
 * https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 *
 * @author jiyingdabj
 */
public class Leet1326 {

    public static void main(String[] args) {
        int i = minTaps(5, new int[]{3,4,1,1,0,0});
        System.out.println(i);
    }


    public static int minTaps(int n, int[] ranges) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < ranges.length ;i++) {
            list.add(new Pair(i - ranges[i], i + ranges[i]));
        }
        list.sort(Comparator.comparing(e -> e.f));
        int i = 0;
        int max = 0;
        int t = 0;
        int j = 0;
        while (i <= n && j <= n) {
            for (; j < list.size(); j++) {
                Pair pair = list.get(j);
                if (i >= pair.f && i <= pair.s) {
                    max = Math.max(max, pair.s);
                } else {
                    if (max == i) {
                        return -1;
                    }
                    i = max;
                    t++;
                    break;
                }
            }
        }
        if (j >= n) {
          return t+1;
        }
        return -1;
    }

    static class Pair {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}
