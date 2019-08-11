package jyd.leet;

/**
 * @author jiyingda
 * @date 2019/8/11
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet21 {

    public static void main(String[] args){
        ListNode a1 = new ListNode(7);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(9);


        a2.next = a3;
        a1.next = a2;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(11);

        b3.next = b4;
        b2.next = b3;
        b1.next = b2;
        mergeTwoLists(a1, b1);
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
