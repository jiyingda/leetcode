/**
 * @(#)T2.java, 11月 07, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.tree.TreeNode;
import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author jiyingda
 */
public class T2 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (words[0] == board[i][j]) {
                    int[][] used = new int[n][m];
                    boolean f = dfs(board, i, j, n, m, words, 0, used);
                    if (f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int n, int m, char[] words, int k, int[][] used) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        if (used[i][j] == 1) {
            return false;
        }
        if (board[i][j] != words[k]) {
            return false;
        }
        if (k + 1 == words.length) {
            return true;
        }
        used[i][j] = 1;
        boolean f1 = dfs(board, i - 1, j, n, m, words, k + 1, used);
        if (f1) {
            return true;
        }
        boolean f2 = dfs(board, i + 1, j, n, m, words, k + 1, used);
        if (f2) {
            return true;
        }
        boolean f3 = dfs(board, i, j + 1, n, m, words, k + 1, used);
        if (f3) {
            return true;
        }
        boolean f4 = dfs(board, i, j - 1, n, m, words, k + 1, used);
        if (f4) {
            return true;
        }
        used[i][j] = 0;
        return false;
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    c++;
                }
            }
        }
        return c;
    }

    public void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i, j - 1, n, m);
        dfs(grid, i, j + 1, n, m);
    }


    public static List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList<>();
        if (digits.length() <= 0) {
            return r;
        }
        char[] d = new char[digits.length()];
        dffs(digits.toCharArray(), 0, d, 0, r);
        return r;
    }

    static Map<Character, char[]> map = new HashMap<Character, char[]>() {
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };

    public static void dffs(char[] c, int i, char[] d, int j, List<String> r) {
        if (j >= d.length) {
            r.add(String.valueOf(d));
            return;
        }
        char cc = c[i];
        char[] list = map.get(cc);
        for (char ccc : list) {
            d[j] = ccc;
            dffs(c, i + 1, d, j + 1, r);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n, n, list, new StringBuilder());
        return list;
    }

    public void generateParenthesis(int i, int j, List<String> list, StringBuilder sb) {
        if (i == 0 && j == 0) {
            list.add(sb.toString());
            return;
        }
        if (i >= j) {
            sb.append('(');
            generateParenthesis(i - 1, j, list, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (i > 0) {
            sb.append('(');
            generateParenthesis(i - 1, j, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (j > 0) {
            sb.append(')');
            generateParenthesis(i, j - 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), r);
        return r;
    }

    public void permute(int[] nums, boolean[] status, List<Integer> list, List<List<Integer>> r) {
        if (list.size() == nums.length) {
            r.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (status[j]) {
                continue;
            }
            list.add(nums[j]);
            status[j] = true;
            permute(nums, status, list, r);
            status[j] = false;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), r);
        return r;
    }

    public void subsets(int[] nums, int i, List<Integer> list, List<List<Integer>> r) {
        r.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            subsets(nums, j + 1, list, r);
            list.remove(list.size() - 1);
        }
    }

    // [2,0,2,1,1,0]
    public void sortColors(int[] nums) {
        int i = 0;
        int a0 = 0, a2 = nums.length - 1;
        while (i <= a2) {
            if (nums[i] == 0) {
                swap(nums, i, a0);
                a0++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, a2);
                a2--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == separator) {
                    if (len > 0) {
                        list.add(s.substring(i - len, i));
                    }
                    len = 0;
                } else {
                    len++;
                }
            }
            if (len > 0) {
                list.add(s.substring(s.length() - len, s.length()));
            }
        }
        return list;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] r = new int[k];
        List<Integer> l = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .limit(k)
                .map(e -> e.getKey()).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            r[i] = l.get(i);
        }
        return r;
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int LEFT, int RIGHT) {
        if (LEFT == RIGHT) {
            return nums[LEFT];
        }

        int j = RIGHT;
        int tag = nums[LEFT];
        int p = LEFT;
        int i = LEFT + 1;

        while (i < j) {
            while (i < j && nums[i] >= tag) {
                i++;
            }
            while (j > i && nums[j] < tag) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, p, i);
        p = i;
        if (p == (k-1)) {
            return nums[p];
        } else if (p < (k-1)) {
            return findKthLargest(nums, k, p + 1, RIGHT);
        }
        return findKthLargest(nums, k, LEFT, p - 1);
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        int a = t2.findKthLargest(new int[]{-1,2,0,3,4}, 1);
        System.out.print(a);
        /*List<String> words = Arrays.asList("one.two.three","four.five","six");
        char separator = '.';
        PrintUtils.printArray(t2.splitWordsBySeparator(words, separator));*/
        /*int[] nums = new int[]{0,0,1,1,2,2,2};
        t2.sortColors(nums);
        PrintUtils.printArray(nums);*/
        /*char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.print(t2.exist(board, word));*/
        //PrintUtils.printArray(t2.subsets(new int[]{1,2,3}));

        // PrintUtils.printArray(letterCombinations("9"));

        /*char[][] grid = new char[][]{
                {'1','1','1','0','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'}};
        T2 t2 = new T2();
        int a = t2.numIslands(grid);
        System.out.print(a);*/
    }

    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k, new int[1]);
    }

    public int dfs(TreeNode root, int k, int[] l) {
        if (root == null) {
            return -1;
        }
        int a = dfs(root.left, k, l);
        if (a >= 0) {
            return a;
        }
        l[0]++;
        if (l[0] == k) {
            return root.val;
        }
        return dfs(root.right, k, l);
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int i = deque.size();
            Node first = deque.pollFirst();
            if (first.left != null) {
                deque.offerLast(first.left);
                deque.offerLast(first.right);
            }
            i--;
            while (i > 0) {
                Node node = deque.pollFirst();
                first.next = node;
                first = first.next;
                if (node.left != null) {
                    deque.offerLast(node.left);
                    deque.offerLast(node.right);
                }
                i--;
            }
        }
        return root;

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
