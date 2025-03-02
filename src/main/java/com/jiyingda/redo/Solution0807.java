/**
 * @(#)Solution0807.java, 8月 07, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jiyingda
 */
public class Solution0807 {
    public static void main(String[] args) {

        Solution0807 randomizedSet = new Solution0807();
        System.out.println(randomizedSet.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomizedSet.remove(2)); // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomizedSet.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomizedSet.getRandom()); // getRandom 应随机返回 1 或 2 。
        System.out.println(randomizedSet.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(randomizedSet.insert(2)); // 2 已在集合中，所以返回 false 。
        System.out.println(randomizedSet.getRandom()); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。


    }

    private List<Integer> list;

    private Map<Integer, Integer> set;

    private Random random;

    public Solution0807() {
        list = new ArrayList<>();
        set = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (set.containsKey(val)) {
            return false;
        }
        list.add(val);
        set.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!set.containsKey(val)) {
            return false;
        }
        int idx = set.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        set.put(last, idx);
        set.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}