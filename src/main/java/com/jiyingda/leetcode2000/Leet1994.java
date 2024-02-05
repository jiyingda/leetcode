/**
 * @(#)Leet1994.java, 2月 22, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果 nums 的一个子集中，所有元素的乘积可以表示为一个或多个 互不相同的质数 的乘积，那么我们称它为 好子集 。
 *
 * 比方说，如果 nums = [1, 2, 3, 4] ：
 * [2, 3] ，[1, 2, 3] 和 [1, 3] 是 好 子集，乘积分别为 6 = 2*3 ，6 = 2*3 和 3 = 3 。
 * [1, 4] 和 [4] 不是 好 子集，因为乘积分别为 4 = 2*2 和 4 = 2*2 。
 * 请你返回 nums 中不同的 好 子集的数目对 109 + 7 取余 的结果。
 *
 * nums 中的 子集 是通过删除 nums 中一些（可能一个都不删除，也可能全部都删除）元素后剩余元素组成的数组。如果两个子集删除的下标不同，那么它们被视为不同的子集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：6
 * 解释：好子集为：
 * - [1,2]：乘积为 2 ，可以表示为质数 2 的乘积。
 * - [1,2,3]：乘积为 6 ，可以表示为互不相同的质数 2 和 3 的乘积。
 * - [1,3]：乘积为 3 ，可以表示为质数 3 的乘积。
 * - [2]：乘积为 2 ，可以表示为质数 2 的乘积。
 * - [2,3]：乘积为 6 ，可以表示为互不相同的质数 2 和 3 的乘积。
 * - [3]：乘积为 3 ，可以表示为质数 3 的乘积。
 * 示例 2：
 *
 * 输入：nums = [4,2,3,15]
 * 输出：5
 * 解释：好子集为：
 * - [2]：乘积为 2 ，可以表示为质数 2 的乘积。
 * - [2,3]：乘积为 6 ，可以表示为互不相同质数 2 和 3 的乘积。
 * - [2,15]：乘积为 30 ，可以表示为互不相同质数 2，3 和 5 的乘积。
 * - [3]：乘积为 3 ，可以表示为质数 3 的乘积。
 * - [15]：乘积为 15 ，可以表示为互不相同质数 3 和 5 的乘积。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-number-of-good-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet1994 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,10,1,26,24,21,24,23,11,12,27,4,17,16,2,6,1,1,6,8,13,30,24,20,2,19};
        int sss = numberOfGoodSubsets(nums);
        /*for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + ", ");
            }
            System.out.println("");
        }
        System.out.println("====");*/
        System.out.println(sss);
    }



    public static int numberOfGoodSubsets(int[] nums) {
        int[] ii = new int[]{1,2,3,5,7,11,13,17,19,23,29,6,10,14,22,26,15,21,30};
        Set<Integer> set = new HashSet<>();
        for (int i : ii) {
            set.add(i);
        }

        all = 0;
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[i] = 0;
                z++;
            }
        }
        Arrays.sort(nums);
        numberOfGoodSubsets(nums, z, new ArrayList<>(), new HashMap<>());
        return all;

    }

    //private static List<List<Integer>> list = new ArrayList<>();

    private static int all = 0;

    public static void numberOfGoodSubsets(int[] nums, int k, List<Integer> current, Map<Integer, Integer> map) {
        //list.add(new ArrayList<>(current));
        if (!map.isEmpty()) {
            all++;
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] == 6) {
                if (map.containsKey(2) || map.containsKey(3)) {
                    continue;
                }
                map.put(2, 1);
                map.put(3, 1);
            } else if (nums[i] == 10) {
                if (map.containsKey(2) || map.containsKey(5)) {
                    continue;
                }
                map.put(2, 1);
                map.put(5, 1);
            } else if (nums[i] == 14) {
                if (map.containsKey(2) || map.containsKey(7)) {
                    continue;
                }
                map.put(2, 1);
                map.put(7, 1);
            } else if (nums[i] == 22) {
                if (map.containsKey(2) || map.containsKey(11)) {
                    continue;
                }
                map.put(2, 1);
                map.put(11, 1);
            } else if (nums[i] == 26) {
                if (map.containsKey(2) || map.containsKey(13)) {
                    continue;
                }
                map.put(2, 1);
                map.put(13, 1);
            }  else if (nums[i] == 15) {
                if (map.containsKey(3) || map.containsKey(5)) {
                    continue;
                }
                map.put(3, 1);
                map.put(5, 1);
            }  else if (nums[i] == 21) {
                if (map.containsKey(3) || map.containsKey(7)) {
                    continue;
                }
                map.put(3, 1);
                map.put(7, 1);
            } else if (nums[i] == 30) {
                if (map.containsKey(2) || map.containsKey(5) || map.containsKey(3)) {
                    continue;
                }
                map.put(2, 1);
                map.put(3, 1);
                map.put(5, 1);
            } else if (nums[i] == 1) {

            }else {
                if (map.containsKey(nums[i])) {
                    continue;
                }
                map.put(nums[i], 1);
            }
            current.add(nums[i]);
            numberOfGoodSubsets(nums, i + 1, current, map);
            int t = current.get(current.size() - 1);
            current.remove(current.size() - 1);
            if (t == 6) {
                map.remove(2);
                map.remove(3);
            } else if (t == 10) {
                map.remove(2);
                map.remove(5);
            } else if (t == 14) {
                map.remove(2);
                map.remove(7);
            } else if (t == 22) {
                map.remove(2);
                map.remove(11);
            } else if (t == 26) {
                map.remove(2);
                map.remove(13);
            }  else if (t == 15) {
                map.remove(3);
                map.remove(5);
            }  else if (t == 21) {
                map.remove(3);
                map.remove(7);
            } else if (t == 30) {
                map.remove(2);
                map.remove(3);
                map.remove(5);
            } else if (t == 1) {

            } else {
                map.remove(t);
            }
        }
    }




    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static final int NUM_MAX = 30;
    static final int MOD = 1000000007;

    public static int numberOfGoodSubsets2(int[] nums) {
        int[] freq = new int[NUM_MAX + 1];
        for (int num : nums) {
            ++freq[num];
        }

        int[] f = new int[1 << PRIMES.length];
        f[0] = 1;
        for (int i = 0; i < freq[1]; ++i) {
            f[0] = f[0] * 2 % MOD;
        }

        for (int i = 2; i <= NUM_MAX; ++i) {
            if (freq[i] == 0) {
                continue;
            }

            // 检查 i 的每个质因数是否均不超过 1 个
            int subset = 0, x = i;
            boolean check = true;
            for (int j = 0; j < PRIMES.length; ++j) {
                int prime = PRIMES[j];
                if (x % (prime * prime) == 0) {
                    check = false;
                    break;
                }
                if (x % prime == 0) {
                    subset |= (1 << j);
                }
            }
            if (!check) {
                continue;
            }

            // 动态规划
            for (int mask = (1 << PRIMES.length) - 1; mask > 0; --mask) {
                if ((mask & subset) == subset) {
                    f[mask] = (int) ((f[mask] + ((long) f[mask ^ subset]) * freq[i]) % MOD);
                }
            }
        }

        int ans = 0;
        for (int mask = 1, maskMax = (1 << PRIMES.length); mask < maskMax; ++mask) {
            ans = (ans + f[mask]) % MOD;
        }

        return ans;
    }
}
