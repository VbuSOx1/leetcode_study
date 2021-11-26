package elementary_algorithm.linkList;

/**
 * @author weib
 * @date 2021-04-04 10:41
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 用递归和迭代
 */
public class No206_Reverse_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     *  递归
     *  返回反转后的首节点
     *  传入节点反转后为尾节点
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // 反转后的首节点
        ListNode startNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return startNode;
    }






}
