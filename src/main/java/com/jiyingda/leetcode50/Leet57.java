package com.jiyingda.leetcode50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/4/10.
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet57 {

    public static void main(String[] args){
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        insert(intervals, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> reList = new ArrayList<>();
        int len = intervals.length;
        boolean flag = false;
        for(int i =0; i < len; i++){
            if(flag){
                reList.add(intervals[i]);
            } else {
                if(newInterval[1] < intervals[i][0]){
                    reList.add(newInterval);
                    reList.add(intervals[i]);
                    flag = true;
                }else if(newInterval[1] == intervals[i][0]){
                    newInterval[1] = intervals[i][1];
                    reList.add(newInterval);
                    flag = true;
                } else if(newInterval[0] > intervals[i][1]){
                    reList.add(intervals[i]);
                } else if(newInterval[0] <= intervals[i][1]){
                    if(newInterval[0] > intervals[i][0]){
                        newInterval[0] = intervals[i][0];
                    }

                    if(newInterval[1] >= intervals[i][1]){

                    } else {
                        newInterval[1] = intervals[i][1];
                    }
                }
            }
        }
        if(!flag){
            reList.add(newInterval);
        }

        int[][] rrr = new int[reList.size()][2];
        int i = 0;
        for(int[] r : reList){
            rrr[i] = r;
            i++;
        }
        return rrr;
    }
}
