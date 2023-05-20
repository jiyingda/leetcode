/**
 * @(#)Leet1042.java, 4月 15, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.util.PrintUtils;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 *
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 *
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 *
 * @author jiyingda
 */
public class Leet1042 {
    public static void main(String[] args) {
        int[] a = gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}});
        PrintUtils.printArray(a);
    }

    public static int[] gardenNoAdj(int n, int[][] paths) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : paths) {
            if (map.containsKey(p[0])) {
                map.get(p[0]).add(p[1]);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(p[1]);
                map.put(p[0], s);
            }
            if (map.containsKey(p[1])) {
                map.get(p[1]).add(p[0]);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(p[0]);
                map.put(p[1], s);
            }
        }

        int[] r = new int[n];
        for (int a = 1; a <=n; a++) {
            if (r[a-1] <= 0) {
                Set<Integer> others = map.get(a);
                if (others == null || others.isEmpty()) {
                    r[a-1] = 1;
                } else {
                    Set<Integer> all = new HashSet<>();
                    all.add(1);
                    all.add(2);
                    all.add(3);
                    all.add(4);
                    for (int b : others) {
                        if (r[b-1] > 0) {
                            all.remove(r[b-1]);
                        }
                    }
                    r[a-1] = all.stream().findFirst().get();
                }
            }
        }
        return r;
    }
}