package com.jiyingda.leetcode200;

import java.util.*;

/**
 *
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/23 20:54
 */
public class Leet179 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("99");
        list.add("9");
        list.add("910");
        list.add("92");
        //Collections.sort(list);


        int[] nums = {0,0};
        System.out.print(largestNumber(nums));;

    }

    public static String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for(int i = 0; i < nums.length; ++ i) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs,(o1,o2)->(o1+o2).compareTo(o2+o1));
        StringBuilder sb = new StringBuilder();
        for(int i = nums.length-1; i >= 0; -- i) {
            sb.append(numStrs[i]);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
