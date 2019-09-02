package com.jiyingda.leetcode;

public class leet4 {

    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }




    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int lenght2 = nums2.length;
        int midle2 = (length1 + lenght2) / 2;
        int midle1 = midle2;
        if((length1 + lenght2) % 2 == 0){
             midle1 -= 1;
        }
        if(length1 == 0 && lenght2 == 0){
            return 0.0;
        }
        if(length1 == 0){
            return ((double) nums2[midle1] + nums2[midle2])/2;
        }
        if(lenght2 == 0){
            return ((double) nums1[midle1] + nums1[midle2])/2;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        int m1 = 0;
        int m2 = 0;
        while (k <= midle2 && i < length1 && j < lenght2){
                if(nums1[i] < nums2[j]){
                    if(k == midle1){
                        m1 = nums1[i];
                    }
                    if(k == midle2){
                        m2 = nums1[i];
                    }
                    i++;
                }  else{
                    if(k == midle1){
                        m1 = nums2[j];
                    }
                    if(k == midle2){
                        m2 = nums2[j];
                    }
                    j++;
                }
            k++;
        }
        if(i < length1){
            while (k <= midle2){
                if(k == midle1){
                    m1 = nums1[i];
                }
                if(k == midle2){
                    m2 = nums1[i];
                    break;
                }
                i++;
                k++;
            }
        }
        if(j < lenght2){
            while (k <= midle2){
                if(k == midle1){
                    m1 = nums2[j];
                }
                if(k == midle2){
                    m2 = nums2[j];
                    break;
                }
                j++;
                k++;
            }

        }

        return ((double) m1 +  m2)/2;

    }
}
