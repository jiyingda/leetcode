package com.jiyingda.leetcode50;

import java.util.*;

/**
 * @author jiyingda.
 * @date 2020/3/23.
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet46 {

    public static void main(String[] args){


        Long a = System.currentTimeMillis();
        int[] nums = {1,2,3,4};//,4,5,6,7,8,9};
        List<List<Integer>> ss = permute(nums);
        Long b = System.currentTimeMillis();
        System.out.println(b-a);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    public static List<List<Integer>> permute2(int[] nums) {
        List<Integer> data = new ArrayList<>();
        for(int a : nums){
            data.add(a);
        }
        List<List<Integer>> reList = new ArrayList<>();

        arrangeSelect(data, new ArrayList<>(),data.size(), reList);
        return reList;
    }
    /**
     * 计算A(n,k)
     *
     * @param target
     * @param k
     */
    public static void arrangeSelect(List<Integer> data,List<Integer> target,int k, List<List<Integer>> reList) {


        Set<Integer> aa = new HashSet<>();
        List<Integer> copyData;
        List<Integer> copyTarget;
        if(target.size() == k) {
            List<Integer> tmp = new ArrayList<>(target);
            reList.add(tmp);
        }

        for(int i=0; i<data.size(); i++) {
            if(aa.contains(data.get(i))){
                continue;
            }
            aa.add(data.get(i));
            copyData = new ArrayList<>(data);
            copyTarget = new ArrayList<>(target);

            copyTarget.add(copyData.get(i));
            copyData.remove(i);

            arrangeSelect(copyData, copyTarget,k, reList);
        }

    }
}
