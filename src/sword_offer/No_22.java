package sword_offer;

/**
 * @author weib
 * @date 2021-12-13 15:25
 * 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class No_22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        while (k-- > 1 && p != null){
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        return q;

    }
}
