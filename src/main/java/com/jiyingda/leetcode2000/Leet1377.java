/**
 * @(#)Leet1377.java, 5月 24, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 *
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
 *
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10-5 的结果将被视为正确答案。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * 输出：0.3333333333333333
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
 *
 *
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 *
 * @author jiyingdabj
 */
public class Leet1377 {

    public static void main(String[] args) {
        Leet1377 leet1377 = new Leet1377();
        int[][] edges = new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        double s = leet1377.frogPosition(7, edges, 0, 7);
        System.out.println(s);

    }

    public double frogPosition(int n, int[][] edges, int t, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int[] e : edges) {
            if (set.contains(e[0])) {
                if (map.containsKey(e[0])) {
                    map.get(e[0]).add(e[1]);
                } else {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(e[1]);
                    map.put(e[0], ll);
                }
                set.add(e[1]);
            } else {
                if (map.containsKey(e[1])) {
                    map.get(e[1]).add(e[0]);
                } else {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(e[0]);
                    map.put(e[1], ll);
                }
                set.add(e[0]);
            }
        }
        List<A> preList = new ArrayList<>();
        A a = new A(1 ,1 );
        preList.add(a);
        int i = 0;
        while (i < t) {
            List<A> ccList = new ArrayList<>();
            for (A b : preList) {
                if (target == b.edg) {
                    ccList.clear();
                    List<Integer> temp = map.get(b.edg);
                    if (temp == null || temp.isEmpty()) {
                        ccList.add(b);
                    } else {
                        double s = b.score / temp.size();
                        for (int c : temp) {
                            ccList.add(new A(c, s));
                        }
                    }
                    break;
                } else {
                    List<Integer> temp = map.get(b.edg);
                    if (temp == null || temp.isEmpty()) {
                        ccList.add(b);
                    } else {
                        double s = b.score / temp.size();
                        for (int c : temp) {
                            ccList.add(new A(c, s));
                        }

                    }
                }

            }
            preList = ccList;

            i++;
        }
        for (A d : preList) {
            if (d.edg == target) {
                return d.score;
            }
        }
        return 0D;
    }

    class A {
        int edg;
        double score;

        public A(int edg, double score) {
            this.edg = edg;
            this.score = score;
        }
    }
}
