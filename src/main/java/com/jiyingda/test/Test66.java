/**
 * @(#)Test66.java, 5月 15, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.tree.TreeNode;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jiyingdabj
 */
public class Test66 {

    public static void main(String[] args) {
        String sss = "[{\"stage\":1,\"stageName\":\"OCR识别完成\",\"startTimeMillis\":1684303566374,\"endTimeMillis\":1684303567315},{\"stage\":2,\"stageName\":\"chatGPT点评完成\",\"startTimeMillis\":1684303567365,\"endTimeMillis\":1684303586458},{\"stage\":3,\"stageName\":\"chatGPT好句\",\"startTimeMillis\":1684303567367,\"endTimeMillis\":1684303570421},{\"stage\":4,\"stageName\":\"错别字标注完成\",\"startTimeMillis\":1684303567369,\"endTimeMillis\":1684303567530},{\"stage\":5,\"stageName\":\"点评\",\"startTimeMillis\":1684303567362,\"endTimeMillis\":1684303586458}]";
        JSONArray array = JSONArray.parseArray(sss);
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            long l = obj.getLong("startTimeMillis");
            long l2 = obj.getLong("endTimeMillis");
            String name = obj.getString("stageName");
            Date ll = new Date(l);
            Date ll2 = new Date(l2);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(name + "  :  " +  format.format(ll) + " -> " + format.format(ll2));
        }

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int len = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = deque.poll();
                if (n.left != null) {
                    deque.offer(n.left);
                }
                if (n.right != null) {
                    deque.offer(n.right);
                }
            }
            len++;
        }
        return len;

    }

    public boolean isValidBST(TreeNode root) {
        int[] a = dfs(root);
        return a[0] <= a[1];

    }

    public int[] dfs(TreeNode root) {
        int a = root.val;
        int b = root.val;
        if (root.left != null) {
            int[] ll = dfs(root.left);
            if (ll[0] > ll[1]) {
                return ll;
            }
            if (ll[1] < a) {
                a = ll[0];
            } else {
                return new int[]{1, 0};
            }

        }
        if (root.right != null) {
            int[] ll = dfs(root.right);
            if (ll[0] > ll[1]) {
                return ll;
            }
            if (ll[0] > b) {
                b = ll[1];
            } else {
                return new int[]{1, 0};
            }
        }
        return new int[]{a, b};
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid -1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (k >= 0 && i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
