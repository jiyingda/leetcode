package com.jiyingda.sort;

/**
 *
 * 简单的插入排序
 *
 * @author jiyingda.
 * @date 2020/2/26.
 */
public class InsertionSort {

    public static void main(String[] args){
        int[] a = {2,1,3,7,5,4};
        insertionSort(a);
    }

    static void insertionSort(int[] a){
        int j;
        for(int p = 1; p < a.length; p++){
            int tmp = a[p];
            for(j = p; j > 0 && tmp < a[j-1]; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }
}
