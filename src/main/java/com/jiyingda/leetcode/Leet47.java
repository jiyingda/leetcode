package com.jiyingda.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingda.
 * @date 2020/3/23.
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> data = new ArrayList<>();
        for(int a : nums){
            data.add(a);
        }
        List<List<Integer>> reList = new ArrayList<>();
        arrangeSelect(data, new ArrayList<>(), nums.length, reList);
        return reList;
    }

    public static void arrangeSelect(List<Integer> data,List<Integer> target, int k, List<List<Integer>> reList) {

        List<Integer> copyData;
        List<Integer> copyTarget;
        if(target.size() == k) {
            List<Integer> tmp = new ArrayList<>(target);
            reList.add(tmp);
            /*for(Integer a : tmp){
                System.out.print(a);
            }
            System.out.println();*/
        }
        Set<Integer> aa = new HashSet<>();

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
