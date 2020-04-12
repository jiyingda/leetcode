package com.jiyingda.leetcode50;

/**
 * @author jiyingda.
 * @date 2020/3/10.
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet42 {


    public static void main(String[] args){

        int[] height = {0,0,0};
        System.out.println(trap(height));;

    }

    public static int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }

        int i = 0;
        int j = height.length-1;
        int left = 0;
        int right = 0;
        int all = 0;

        while (i < j && height[i] <= 0){
            i++;
        }
        while (i < j && height[j] <= 0){
            j--;
        }
        left = height[i];
        right = height[j];

        while (i < j){
            if(left <= right){
                while (i < j) {
                    i++;
                    if(left <= height[i]){
                        left = height[i];
                        break;
                    } else {
                        all += left - height[i];
                    }
                }
            } else {
                while (i < j) {
                    j--;
                    if(right <= height[j]){
                        right = height[j];
                        break;
                    } else {
                        all += right - height[j];
                    }
                }
            }
        }
        return all;
    }

}
