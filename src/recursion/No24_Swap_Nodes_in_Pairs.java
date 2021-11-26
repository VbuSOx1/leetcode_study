package recursion;

/**
 * @author weib
 * @date 2021-05-15 10:00
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 两两交换链表中的节点
 */
public class No24_Swap_Nodes_in_Pairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 非递归解法 注意每两个为一组交换之后
     * 每组之间的链接
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode p, q;
        ListNode t = new ListNode();
        p = head;
        q = head.next;
        head = q;
        while(q != null){
            p.next = q.next;
            q.next = p;
            // 上一组
            t.next = q;
            t = p;
            p = p.next;
            if(p == null){
                return head;
            }
            q = p.next;
        }
        return head;
    }
}

































