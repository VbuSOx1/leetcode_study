package sword_offer;

/**
 * @author weib
 * @date 2021-12-13 15:42
 *  25. 合并两个排序的链表
 *  https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class No_25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        while (l1 != null && l2 != null){
            if ( l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1==null?l2:l1;
        return head.next;

    }

}
