/**
 * @(#)T1.java, 4月 13, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.entity.ListNode;
import com.jiyingda.leetcode150.Leet138;
import com.jiyingda.tree.TreeNode;
import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author jiyingda
 */
public class T1 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        int len = chars.length;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (j < len) {
            if (set.contains(chars[j])) {
                while (chars[i] != chars[j]) {
                    set.remove(chars[i]);
                    i++;
                }
                i++;
            } else {
                set.add(chars[j]);
                max = Math.max(max, set.size());
            }
            j++;
        }
        return max;
    }

    public String longestPalindrome(String s) {
        int max = 1;
        int[] maxStr = new int[]{0,0};
        int i = 0, j = 0;
        char[] arrays = s.toCharArray();
        while (j < s.length()) {
            int[] r = isdd(arrays, i, j);
            if (r[1] - r[0] > max) {
                max = r[1] - r[0];
                maxStr = r;
            }
            if (i < j) {
                i++;
            } else {
                j++;
            }
        }
        return s.substring(maxStr[0], maxStr[1] + 1);
    }

    public int[] isdd(char[] arrays, int i, int j) {
        if (arrays[i] != arrays[j]) {
            return new int[]{0, 0};
        }
        while (arrays[i] == arrays[j]) {
            if (i <= 0 || j == arrays.length-1) {
                break;
            }
            i--;
            j++;
        }
        return new int[]{i, j};
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re = new ListNode(0);
        ListNode l3 = re;
        int p = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val + l2.val + p;
            p = 0;
            if (a > 9) {
                p = 1;
                a = a - 10;
            }
            ListNode t = new ListNode(a);
            l3.next = t;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int a = l1.val + p;
            p = 0;
            if (a > 9) {
                p = 1;
                a = a - 10;
            }
            l3.next = new ListNode(a);
            l3 = l3.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int a = l2.val + p;
            p = 0;
            if (a > 9) {
                p = 1;
                a = a - 10;
            }
            l3.next = new ListNode(a);
            l3 = l3.next;
            l2 = l2.next;
        }
        if (p == 1) {
            l3.next = new ListNode(1);
        }
        return re.next;

    }

    public ListNode oddEvenList(ListNode head) {
        ListNode n1 = new ListNode(0);
        ListNode r1 = n1;
        ListNode n2 = new ListNode(0);
        ListNode r2 = n2;
        boolean f = true;
        while (head != null) {
            if (f) {
                n1.next = head;
                n1 = n1.next;
                f = false;
            } else {
                n2.next = head;
                n2 = n2.next;
                f = true;
            }
            head = head.next;
        }
        n2.next = null;
        n1.next = r2.next;
        return r1.next;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public int vowelStrings(String[] words, int left, int right) {
        int n = 0;
        for (int i = left; i <= right; i++) {
            if (vowelString(words[i])) {
                n++;
            }
        }
        return n;
    }

    public boolean vowelString(String s) {
        return set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1));
    }


    public static void main(String[] args) {


        T1 t1 = new T1();

        // PrintUtils.printArray(t1.threeSum(new int[]{-1,0,1,2,-1,-4}));
        // System.out.print(t1.lengthOfLongestSubstring("aavaa"));
        // System.out.print(t1.longestPalindrome("aavaaabbbba"));
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n5;
        t1.oddEvenList(n1);


    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (k > j) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                if ((j - 1 > i && nums[j] == nums[j - 1])) {
                    j++;
                    continue;
                }
                int a = nums[i] + nums[j] + nums[k];
                if (a == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (a < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;

    }

    public void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    setX.add(i);
                    setY.add(j);
                }
            }
        }
        for (int i : setX) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : setY) {
            for (int i = 0; i < x; i++) {
                matrix[i][j] = 0;
            }
        }

    }
}