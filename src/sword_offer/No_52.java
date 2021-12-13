package sword_offer;

/**
 * @author weib
 * @date 2021-12-13 16:18
 * 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 */
public class No_52 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        int lenA = 1;
        int lenB = 1;
        // 走到最后一个节点
        while (pa.next != null) {
            pa = pa.next;
            lenA++;
        }
        while (pb.next != null) {
            pb = pb.next;
            lenB++;
        }
        if (lenA < lenB) {
            pa = headB;
            pb = headA;
        }else {
            pa = headA;
            pb = headB;
        }
        int diff = Math.abs(lenA -lenB);
        // 同步
        while (diff-- > 0) {
            pa = pa.next;
        }
        while (pa != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}
