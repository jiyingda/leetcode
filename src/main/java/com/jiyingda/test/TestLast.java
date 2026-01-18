/**
 * @(#)TestLast.java, 10月 24, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author jiyingdabj
 */
public class TestLast {

    public  static void main(String[] args) {
        // 创建TestLast实例，准备测试排序
        TestLast last = new TestLast();
        int[] nums = new int[]{1,5,3,2,4,8,7,6};
        // 调用自定义排序方法
        last.sort(nums);
        // 打印排序后的数组
        PrintUtils.printArray(nums);
    }

    /**
     * 快速排序入口方法
     * @param nums 待排序数组
     */
    public void sort(int[] nums) {
        dfs(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序递归实现
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     */
    public void dfs(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 分区，获取基准元素位置
        int p = partition(nums, left, right);
        // 递归排序左半部分
        dfs(nums, left, p - 1);
        // 递归排序右半部分
        dfs(nums, p + 1, right);
    }

    /**
     * 分区操作，返回基准元素最终位置
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     * @return 基准元素位置
     */
    public int partition(int[] nums, int left, int right) {
        int base = nums[left]; // 选取最左侧为基准
        int i = left, j = right;
        while (i < j) {
            // 从右向左找第一个小于基准的数
            while (i < j && nums[j] >= base) j--;
            // 直接赋值，减少一次交换
            if (i < j) nums[i++] = nums[j];
            // 从左向右找第一个大于基准的数
            while (i < j && nums[i] <= base) i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = base; // 基准归位
        return i;
    }
}