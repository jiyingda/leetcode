package com.jiyingda.Leetcode;

/**
 * @author jiyingda
 * @date 2019/8/15
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet19 {

    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
/*        l4.next = l5;
        l3.next = l4;
        l2.next = l3;*/
        l1.next = l2;

        ListNode re = removeNthFromEnd(l1, 2);
        System.out.println(re);
    }



    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode re = head;
        ListNode del = null;
        ListNode ne = null;
        int i = 1;
        while (head != null) {
            if(i - n == 0){
                del = re;
            }
            if(i -n > 0){
                ne = del;
                del = del.next;
            }
            head = head.next;
            i++;
        }
        if(ne != null){
            ne.next = del.next;


        }else if(del != null){
            re = re.next;
        }

        return re;

    }
}
