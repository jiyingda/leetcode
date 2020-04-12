package com.jiyingda.leetcode100;

import com.jiyingda.entity.ListNode;
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
        ListNode head5 = new ListNode(5);
        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;
        ListNode re = reverseBetween(head1,1 ,5);
        System.out.println(re);

    }



    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null){
            return null;
        }
        boolean flag = false;
        if(m == 1){
            ListNode tt = new ListNode(0);
            tt.next = head;
            head = tt;
            m++;
            n++;
            flag = true;
        }

        ListNode result = head;
        ListNode re = head;
        int i = 1;
        while(head != null && i <= n){
            if(i < m - 1){
                head = head.next;
                re = re.next;
            } else if(i == m - 1){
                head = head.next;
            } else if(i < n){
                ListNode tmp = head.next;
                head.next = head.next.next;
                tmp.next = re.next;
                re.next = tmp;
            }
            i++;
        }
        if(flag){
            return result.next;
        }

        return result;
    }
}
