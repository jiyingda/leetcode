package com.jiyingda.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/4/10.
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet56 {

    public static void main(String[] args){
        int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] rr = merge(intervals);
        System.out.print(Arrays.toString(rr));
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> reList = new ArrayList<>();
        int[] current = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(current[1] >= interval[0]){
                if(current[1] < interval[1]){
                    current[1] = interval[1];
                }
            } else {
                reList.add(new int[]{current[0], current[1]});
                current = interval;
            }
        }
        reList.add(current);
        int[][] rrr = new int[reList.size()][2];
        for (int i = 0; i < reList.size(); i++) {
            rrr[i] = reList.get(i);
        }
        return rrr;
    }

    public static int[][] merge2(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        List<Interval> list = new ArrayList<>();
        for(int i =0 ;i < intervals.length; i++){
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        list.sort(Comparator.comparingInt(Interval::getA));
        List<Interval> reList = new ArrayList<>();
        Interval current = list.get(0);
        for(Interval interval : list){
            if(current.b >= interval.a){
                if(current.b < interval.b){
                    current.b = interval.b;
                }
            } else {
                reList.add(new Interval(current.a, current.b));
                current = interval;
            }

        }
        reList.add(current);
        int[][] rrr = new int[reList.size()][2];
        int  i = 0;
        for(Interval interval : reList){
            rrr[i][0] = interval.a;
            rrr[i][1] = interval.b;
            i++;
        }

        return rrr;
    }

    static class Interval {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }
    }
}
