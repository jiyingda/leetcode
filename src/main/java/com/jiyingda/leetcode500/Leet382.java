/**
 * @(#)Leet382.java, 8月 17, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import com.jiyingda.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 *
 * 实现 Solution 类：
 *
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 *  
 *
 * 示例：
 *
 *
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet382 {
    private int size;
    private int[] values;
    private Random r;
    private List<Integer> list;

    public Leet382(ListNode head) {
        r = new Random();
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        size = list.size();
        /*int[] values = new int[size];
        int i = 0;
        for (Integer v : list) {
            values[i] = v;
            i++;
        }*/
    }

    public int getRandom() {
        return list.get(r.nextInt(size));
    }
}
