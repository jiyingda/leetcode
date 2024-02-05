package com.jiyingda.leetcode1000;

import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 *
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 *
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * 示例 2：
 *
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *
 *
 * 提示：
 *
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 *
 * @author jiyingda
 * @date 2023/5/4
 */
public class Leet970 {

    public static void main(String[] args) {
        Leet970 leet970 = new Leet970();
        PrintUtils.printArray(leet970.powerfulIntegers(3, 5,15));

    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set  = new HashSet<>();
        dfs(x, y, bound, 1, 1, set);

        return new ArrayList<>(set);
    }

    public void dfs(int x, int y, int bound, int xx, int yy, Set<Integer> set) {
        int all = xx + yy;
        if (all > bound) {
            return;
        }
        set.add(all);
        if (x != 1) {
            dfs(x, y, bound, xx * x, yy, set);
        }
        if (y != 1 && x != y) {
            dfs(x, y, bound, xx, yy * y, set);
        }
        if (x != 1 && y != 1) {
            dfs(x, y, bound, xx * x, yy * y, set);
        }
    }
}
