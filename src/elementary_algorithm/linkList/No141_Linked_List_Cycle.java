package elementary_algorithm.linkList;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-04-07 14:31
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 环形链表
 * 思路：快慢指针：快的走两步 慢的走一步 直到快的和慢的相遇
 */
public class No141_Linked_List_Cycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null && slow != fast){
            slow = slow.next;
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;
            if(slow == fast){
                return  true;
            }
        }
        if(slow == fast){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = node;

        No141_Linked_List_Cycle no141 = new No141_Linked_List_Cycle();
        System.out.println(no141.hasCycle(node));
    }

}


