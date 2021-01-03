package com.jiyingda.leetcode200;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiyingda
 * @date 2021/1/3 11:13
 */
public class Leet5641 {
    public static void main(String[] args) {
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        System.out.print(maximumUnits(boxTypes, 10));;

    }


    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair2[1] - pair1[1];
            }
        });

        for(int[] s : boxTypes){
            pq.offer(s);
        }
        int max = 0;
        int i = 0;
        while (i < truckSize) {
            int size = truckSize - i;
            int[] tmp = pq.poll();
            if(tmp == null){
                break;
            }
            if(tmp[0] >= size){
                max += size * tmp[1];
                break;
            } else {
                max += tmp[0] * tmp[1];
                i+= tmp[0];
            }
        }


        return max;
    }
}
