package sword_offer;

/**
 * @author weib
 * @date 2021-12-13 15:12
 * 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class No_18 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        while (p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return head;
    }
}
