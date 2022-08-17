/**
 * @(#)Leet253.java, 2月 08, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet253 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,5}, {15,20}, {5,10}};
        minMeetingRooms(intervals);
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] vis = new int[intervals.length];
        Arrays.sort(intervals, Comparator.comparing(e -> e[0]));
        int k = intervals.length;
        int r = 0;
        while (k > 0) {
            int right = -1;
            for (int i = 0; i < intervals.length; i++) {
                if (vis[i] == 1) {
                    continue;
                }
                if (intervals[i][0] >= right) {
                    right = intervals[i][1];
                    vis[i] = 1;
                    k--;
                }
            }
            r++;
        }
        return r;
    }
}
