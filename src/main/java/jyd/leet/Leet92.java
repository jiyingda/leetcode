package jyd.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2019/7/30.
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet92 {


    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;
        ListNode re = reverseBetween(head1,2 ,4);
        System.out.println(re);

    }



    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        list.add(new ListNode(head.val));
        while (head.next != null){
            head = head.next;
            list.add(new ListNode(head.val));
        }
        for(){

        }
        return re;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
