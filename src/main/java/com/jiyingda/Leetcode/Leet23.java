package com.jiyingda.Leetcode;

/**
 * @author jiyingda
 * @date 2019/8/12
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet23 {

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(4);
        ListNode head7 = new ListNode(5);
        ListNode head8 = new ListNode(6);

        head5.next = head7;
        head2.next = head5;

        //head4.next = head6;
        //head1.next = head4;

        //head3.next = head8;


        ListNode[] lists = new ListNode[]{head1, head3};
        System.out.println(mergeKLists(lists));

    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        int size = lists.length;

        while (size > 1) {
            int len = size/2;
            for(int i = 0; i < len; i++){
                ListNode tmp = mergeTwoLists(lists[i], lists[size - 1]);
                lists[i] = tmp;
                lists[size - 1] = null;
                size--;
            }
        }


        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){

        } else {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        ListNode re = l1;
        while (l2 != null){

            while (l1.next != null && l1.next.val <= l2.val){
                l1 = l1.next;
            }
            ListNode temp = l1.next;
            l1.next = l2;
            if(temp == null){
                break;
            }
            while (l2.next != null && l2.next.val <= temp.val){
                l2 = l2.next;
            }
            l1 = l2;
            l2 = l2.next;
            l1.next = temp;
            l1 = l1.next;
        }

        return re;
    }





    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
