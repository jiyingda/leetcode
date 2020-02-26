package com.jiyingda.sort;

/**
 * @author jiyingda.
 * @date 2020/2/26.
 */
public class HeapSort {
    public static void main(String[] args){
        int[] a = {2,1,3,7,5,4};
    }


    private static int leftChild(int i){
        return 2 * i + 1;
    }

    public static void precDown(int[] a, int i, int n){
        int child;
        int tmp;
        for(tmp = a[i]; leftChild(i) < n; i = child){
            child = leftChild(i);
            if(child != n - 1 && a[child] < a[child + 1]){
                child++;
            }
        }
    }
}
