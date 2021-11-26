package elementary_algorithm.linkList;

import java.util.Stack;

/**
 * @author weib
 * @date 2021-04-07 14:00
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表判断
 * 思路：前一半存栈，然后比较（空间复杂度高）
 * 更好的思路：通过快慢指针（p=p.next   q=q.next.next）找到中点，然后逆转后半链表，在往后遍历进行比较
 */
public class No234_Palindrome_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null){
            count++;
            p = p.next;
        }
        if(count < 2){
            return true;
        }
        int[] stack = new int[count/2];
        p = head;
        int i = 0;
        for (; i < count / 2; i++) {
            stack[i] = p.val;
            p = p.next;
        }
        if(count % 2 != 0){
            p = p.next;
        }
        while(p != null){
            if(stack[--i] != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

}
