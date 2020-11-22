package com.jiyingda.test;

import java.util.Arrays;

/**
 * @author jiyingda.
 * @date 2020/11/22.
 */
public class MaxNum {

    public static void main(String[] args){
        int[] arr = new int[]{5,4,6,7,3,8,2,1,9};

        quickSort(arr, 0, arr.length-1, 3);
        for(int a : Arrays.copyOfRange(arr, 0, 4)){
            System.out.print(a);
        }
    }

    static void quickSort(int[] arr, int L, int R,int k){
        if(R <= L){
          return;
        }
        int x = arr[L];
        int i = L;
        int j = R;
        while (i < j) {
            while ( i < j && arr[j] >= x) {
                j--;
            }
            if(i < j){
                arr[i] = arr[j];
            }

            while (i < j && arr[i] < x) {
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
            }
        }
        arr[i] = x;
        if(i == k){

        } else if(i < k){
            quickSort(arr, i+1, R, k);
        } else {
            quickSort(arr, L, i-1, k);
        }
    }
}
