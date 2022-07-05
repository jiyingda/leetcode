/**
 * @(#)Leet954.java, 4月 01, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *  
 *
 * 提示：
 *
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet954 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1, 3);
        System.out.println(list);

        System.out.println(BigDecimal.valueOf(1.60001D).intValue());;
        AtomicInteger a = new AtomicInteger(1);
        System.out.println(a);
        a.addAndGet(10);
        System.out.println(a);
        int[] nums = new int[]{0, 0,3,1,2,6};
        canReorderDoubled(nums);
    }

    public static boolean canReorderDoubled(int[] arr) {
        int z = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] < 0) {
                arr[k] = -arr[k];
            } else if (arr[k] == 0) {
                z++;
            }

        }
        if (z % 2 == 1) {
            return false;
        }
        Arrays.sort(arr);
        int i = z;
        int j = (arr.length - z) / 2 + z;
        while (j < arr.length) {
            if (arr[i] * 2 != arr[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
