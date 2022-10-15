/**
 * @(#)A1.java, 7月 12, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.megrez;

import java.util.Arrays;

/**
 * 练习第一期
 * 只保留万筒条的麻将牌，现在有手牌13张，判断是否听牌以及听的牌是什么
 * https://github.com/MegrezSoftware/codecamp
 * 牌有3种花色*9个数字=27种，每种牌有4张
 * 术语：
 * 对：2张同样的牌
 * 刻：3张同样的牌
 * 顺：同花色三张连续数字的牌
 * 胡牌：14张牌可以按照1对 + 4组（刻或顺）组成
 * 听牌：13张，差1张就可以胡牌
 *
 * @author jiyingdabj
 */
public class Solution1 {

    /** 01-09代表花色一的牌; 11-19代表花色二的牌; 21-29代表花色三的牌 */
    static int[] allCards = new int[]{1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29};

    public static void main(String[] args) {
        int[] cards = new int[]{2,3,3,3,3,4,5,6,6,6,11,12,13};
        int f = check13(cards);
        System.out.print(f);
    }

    /**
     * 判断是否听牌
     */
    public static int check13(int[] cards) {
        int[] pai = new int[30];
        for (int c : cards) {
            pai[c]++;
        }
        for (int other : allCards) {
            if (pai[other] >= 0 && pai[other] < 4) {
                int[] temp = Arrays.copyOf(pai, pai.length);
                temp[other]++;
                boolean f = check14(temp);
                if (f) {
                    return other;
                }
            }
        }
        return -1;
    }

    /**
     * 判断是否胡牌
     */
    public static boolean check14(int[] pai) {
        // 利用回溯来处理多种情况的判断
        return dfs(pai, 0, 0, 0);
    }

    public static boolean dfs(int[] pai, int i, int c3, int c2) {
        while (i < 30 && pai[i] == 0) {
            i++;
        }
        if (i >= 30) {
            return c3 == 4 && c2 == 1;
        }
        if (pai[i] < 0 || c3 > 4 || c2 > 1) {
            return false;
        }
        // pai[i] == 1 必然要连顺
        if (pai[i] == 1) {
            if (i + 2 < 30 && pai[i + 1] > 0 && pai[i + 2] > 0) {
                pai[i]--;
                pai[i + 1]--;
                pai[i + 2]--;
                return dfs(pai, i + 1, c3 + 1, c2);
            } else {
                return false;
            }
        }
        // pai[i] == 2 进行2种情况判断，不行的话进行回溯
        if (pai[i] == 2) {
            // 已经有对了只能选顺
            if (c2 > 0) {
                if (i + 2 < 30 && pai[i + 1] > 1 && pai[i + 2] > 1) {
                    pai[i] = pai[i] -2;
                    pai[i + 1] = pai[i + 1] -2;
                    pai[i + 2] = pai[i + 2] -2;;
                    return dfs(pai, i + 1, c3 + 2, c2);
                } else {
                    return false;
                }
            }
            // 顺已经够了只能选对
            if (c3 >= 4) {
                pai[i] = pai[i] - 2;
                return dfs(pai, i + 1, c3, c2 + 1);
            }
            pai[i] = pai[i] - 2;
            boolean f = dfs(pai, i + 1, c3, c2 + 1);
            if (f) {
                return true;
            }
            // 先尝试选择对子，如果不能胡的话，则进行回溯，再尝试2条顺子
            pai[i] = pai[i] + 2;
            if (i + 2 < 30 && pai[i + 1] > 1 && pai[i + 2] > 1) {
                pai[i] = pai[i] -2;
                pai[i + 1] = pai[i + 1] -2;
                pai[i + 2] = pai[i + 2] -2;
                return dfs(pai, i + 1, c3 + 2, c2);
            }
            return false;
        }
        // pai[i] >= 3 也有2种情况 1,2,3,3,3,3,4,5这种情况会在前面判断pai[i] == 1的时候处理掉
        // 我们只需考虑 选择刻还是对
        // 这边i不加1 因为pi[i]还没用完 让程序接下来判断 pai[i] == 1 或者 pai[i] == 2的情况
        pai[i] = pai[i] - 3;
        boolean f =  dfs(pai, i, c3 + 1, c2);
        if (f) {
            return true;
        }
        pai[i] = pai[i] + 3;
        // 回溯选择对子 这边不可能再出现3条顺的情况 因为等价于3个刻
        pai[i] = pai[i] - 2;
        // i不用加1
        return dfs(pai, i, c3, c2 + 1);

    }
}
