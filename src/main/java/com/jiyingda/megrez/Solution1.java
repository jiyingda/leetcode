/**
 * @(#)A1.java, 7月 12, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.megrez;

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
        int[] cards = new int[]{2,3,4,4,5,6,7,8,8,8,9,9,11};
        boolean f = check13(cards);
        System.out.print(f);
    }

    /**
     * 判断是否听牌
     */
    public static boolean check13(int[] cards) {
        int[] pai = new int[30];
        for (int c : cards) {
            pai[c]++;
        }
        for (int other : allCards) {
            if (pai[other] < 4) {
                pai[other]++;
                boolean f = check14(pai);
                if (f) {
                    return true;
                }
                pai[other]--;
            }
        }
        return false;
    }

    /**
     * 判断是否胡牌
     */
    public static boolean check14(int[] pai) {
        int i = 1;
        while (i < 30) {
            if (pai[i] >= 3) {
                pai[i] = pai[i] - 3;
            } else if (pai[i] == 1) {
                if (i + 2 < 30 && pai[i + 1] > 0 && pai[i + 2] > 0) {
                    pai[i]--;
                    pai[i + 1]--;
                    pai[i + 2]--;
                    i++;
                } else {
                    return false;
                }
            } else if (pai[i] == 2) {
                pai[i] = pai[i] - 2;
                i++;
            } else if (pai[i] < 0) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}
