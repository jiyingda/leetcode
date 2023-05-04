package com.jiyingda.sort;

/**
 * @author jiyin
 * @date 2020/8/2 8:02
 */
public class QuickSort {
    public static void main(String[] args) {


        int[] arr = new int[]{19,5,4,6,7,3,9,2,1,8, 100};
        //quickSort(arr);
        quickSort2(arr);
        for(int a : arr){
            System.out.print(a);
        }

    }


    /**
     * 快速排序，使得整数数组 arr 有序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序，使得整数数组 arr 的 [L, R] 部分有序
     */
    public static void quickSort(int[] arr, int L, int R) {
        if(L < R) {
            // 把数组中随机的一个元素与最后一个元素交换，这样以最后一个元素作为基准值实际上就是以数组中随机的一个元素作为基准值
            //swap(arr, new Random().nextInt(R - L + 1) + L, R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
     *   大于 arr[R] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
     *   小于 arr[R] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
     *   等于 arr[R] 的元素位于[L, R]部分的中间
     * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
     */
    public static int[] partition(int[] arr, int L, int R) {

        int basic = arr[R];
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < basic) {
                swap(arr, ++less, L++);
            } else if (arr[L] > basic) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }

        return new int[] { less + 1, more - 1 };

    }

    /*
     * 交换数组 arr 中下标为 i 和下标为 j 位置的元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort2(int[] array) {
        sort(array, 0, array.length - 1, 3);

    }

    public static void sort(int[] array, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int base = array[left];
        int i = left, j = right;
        while (i < j) {
            while (array[j] >= base && i < j) {
                j--;
            }
            while (array[i] <= base && i < j) {
                i++;
            }
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        array[left] = array[i];
        array[i] = base;
        if (i == k) {
            // 第k个大数

        } else  if (i < k) {
            sort(array, i + 1, right, k);
        } else {
            sort(array, left, i - 1, k);
        }
        // 快排
        //sort(array, left, i - 1, k);
        //sort(array, i + 1, right, k);



    }
}
