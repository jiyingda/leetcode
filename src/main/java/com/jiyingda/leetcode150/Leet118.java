package com.jiyingda.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingda
 * @date 2020/8/3 22:49
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class Leet118 {
    public static void main(String[] args) {
        List<List<Integer>> re = generate(5);
        for(List<Integer> r : re){
            for(Integer i : r){
                System.out.print(i);
            }
            System.out.print("\n");
        }

    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        list.add(Arrays.asList(1));
        if(numRows == 1){
            return list;
        }
        list.add(Arrays.asList(1,1));
        if(numRows == 2){
            return list;
        }
        for(int i = 3; i <= numRows; i++){
            List<Integer> tmp = new ArrayList<>(i);
            tmp.add(1);
            for(int j = 1; j < i-1; j++){
                tmp.add(list.get(i-2).get(j-1) + list.get(i-2).get(j));
            }
            tmp.add(1);
            list.add(tmp);
        }
        return list;

    }
}
