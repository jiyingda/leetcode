package com.jiyingda.leetcode100;

/**
 * @author jiyingda
 * @date 2019/8/11
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet88 {

    public static void main(String[] args){
        int[] nums1 = new int[]{0,0,0};
        int[] nums2 = new int[]{1,2,3};
        merge(nums1, 0, nums2, 3);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            while (n > 0){
                nums1[n-1] = nums2[n-1];
                n--;
            }

            return;
        }
        if(n == 0){
            return;
        }

        int k = m + n -1;
        int i = m-1;
        int j = n-1;
        while ( k >= 0 && j >= 0 ) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
            if(i < 0){
                while (j >= 0){
                    nums1[k] = nums2[j];
                    j--;
                    k--;
                }
            }

        }

    }
}
