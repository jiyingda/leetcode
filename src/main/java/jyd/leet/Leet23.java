package jyd.leet;

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
        if(lists == null){
            return null;
        }
        int size = lists.length;
        if(size == 0){
            return null;
        }
        if(size == 1){
            return lists[0];
        }
        ListNode re = null;
        ListNode result = null;

        while (size > 0){

            for(int i = 0; i < size; i++){
                while (lists[i] == null){
                    lists[i] = lists[size-1];
                    lists[size-1] = null;
                    size--;
                }

            }

        }
        return result;


    }





    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
