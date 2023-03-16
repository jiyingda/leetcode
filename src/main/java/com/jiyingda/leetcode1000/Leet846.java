/**
 * @(#)Leet846.java, 3月 12, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

import java.util.Arrays;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 *
 *
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 * https://leetcode.cn/problems/hand-of-straights/
 *
 * @author jiyingda
 */
public class Leet846 {
    public static void main(String[] args) {
        boolean f = isNStraightHand(new int[]{1,2,3,4, 6}, 1);
        System.out.print(f);
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int f = 0;
        while (f < hand.length) {
            while (f < hand.length && hand[f] == -1) {
                f++;
            }
            if (f >= hand.length) {
                return true;
            }
            int pre = hand[f];
            int i = f + 1;
            hand[f] = -1;
            int size = 1;
            while (size < groupSize) {
                if (i >= hand.length) {
                    return false;
                }
                if (hand[i] == pre) {
                    i++;
                } else if (hand[i] == -1) {
                    i++;
                } else if (hand[i] == pre + 1) {
                    size++;
                    hand[i] = -1;
                    i++;
                    pre++;
                } else {
                    return false;
                }
            }

        }

        return true;

    }
}