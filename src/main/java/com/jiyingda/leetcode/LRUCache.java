package com.jiyingda.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiyingda.
 * @date 2019/9/14.
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int cacheSize;

    public LRUCache(int capacity) {
        cacheSize = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            private static final long serialVersionUID = 1;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRUCache.this.cacheSize;
            }
        };

    }

    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }


    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(1));;
    }
}
