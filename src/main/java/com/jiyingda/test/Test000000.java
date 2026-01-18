/**
 * @(#)Test000000.java, 8月 15, 2024.
 * <p>
 * Copyright 2024 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jiyingdabj
 */
public class Test000000 {

  

    public static void main(String[] args) {
        // 测试快排
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("排序前: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后: " + Arrays.toString(arr));
        
        // 测试随机数组
        Random random = new Random();
        int[] arr2 = new int[20];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(100);
        }
        System.out.println("\n随机数组排序前: " + Arrays.toString(arr2));
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("随机数组排序后: " + Arrays.toString(arr2));
    }
    
    /**
     * 快速排序
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 获取分区点
            int pivotIndex = partition(arr, left, right);
            // 递归排序左半部分
            quickSort(arr, left, pivotIndex - 1);
            // 递归排序右半部分
            quickSort(arr, pivotIndex + 1, right);
        }
    }
    
    /**
     * 分区函数，将数组分为两部分：小于基准值的在左边，大于基准值的在右边
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     * @return 基准值的最终位置
     */
    private static int partition(int[] arr, int left, int right) {
        // 选择最右边的元素作为基准值
        int pivot = arr[right];
        // i 指向小于基准值的区域的最后一个位置
        int i = left - 1;
        
        // 遍历数组，将小于基准值的元素放到左边
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // 将基准值放到正确的位置
        swap(arr, i + 1, right);
        return i + 1;
    }
    
    /**
     * 交换数组中两个元素的位置
     * @param arr 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}