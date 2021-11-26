package elementary_algorithm.linkList;

/**
 * @author weib
 * @date 2021-04-02 16:07
 * 删除链表的倒数第n个值
 * 双指针：第一个先走n步，然后两个指针一起走，
 * 当第一个走到底，第二个指针指的就是倒数第n个值（快慢指针）
 */
public class No019_Remove_Nth_Node_From_End_of_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstPoint = head;
        // 要删除的节点的上一个节点
        ListNode secondPoint = null;
        int index = n;
        while(index > 1){
            firstPoint = firstPoint.next;
            index--;
        }
        // n为链表长 即删除的是head
        if(firstPoint.next == null){
            return head.next;
        }
        secondPoint = head;
        firstPoint = firstPoint.next;
        while(firstPoint.next != null){
            firstPoint = firstPoint.next;
            secondPoint = secondPoint.next;
        }
        secondPoint.next = secondPoint.next.next;
        return head;
    }

    /**
     *  别人的解法 递归 栈
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            return removeNode(head,n)==n?head.next:head;
        }
        public int removeNode(ListNode node,int n) {
            if(node.next == null) {
                return 1;
            }
            int m = removeNode(node.next, n);
            if(m == n) {
                if(m == 1) {
                    node.next = null;
                } else {
                    node.next = node.next.next;
                }
            }
            return m+1;
        }
    }












}
