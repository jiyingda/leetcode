package com.jiyingda.test;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/4/22.
 */
public class RandomList {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(100);
        for(int i = 0; i < 100; i++){
            list.add(i);
        }
        if(CollectionUtils.isEmpty(list)){
            return ;
        }
        int size = 20;
        int sizeAll = list.size();
        if(size <= sizeAll){
            Integer[] knList = list.toArray(new Integer[0]);
            for(int i = 0; i < size; i++){
                int m = RandomList.getRandom(sizeAll);
                RandomList.swap(knList, i, m);
            }
            list = Arrays.asList(Arrays.copyOfRange(knList, 0, 20));
        } else {
            int a = (size-1)/sizeAll + 1;
            List<Integer> tmpList = new ArrayList<>(size);
            Integer[] knList = list.toArray(new Integer[0]);
            for(int j = 0; j < a; j++){
                for(int i = 0; i < sizeAll; i++){
                    int m = RandomList.getRandom(sizeAll);
                    RandomList.swap(knList, i, m);
                }
                tmpList.addAll(Arrays.asList(knList));
            }
            list = tmpList;

        }
        System.out.print(list);

    }


    public static int getRandom(int size){
        return (int) (Math.random() * size);
    }

    public static void swap(Integer[] list, int n, int m){
        Integer tmp = list[n];
        list[n] = list[m];
        list[m] = tmp;
    }
}

