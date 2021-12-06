package sword_offer;

/**
 * @author weib
 * @date 2021-12-03 13:18
 * 翻转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class No_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode rhead = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = rhead;
            rhead = node;
            head = head.next;
        }
        return rhead;
    }
}
