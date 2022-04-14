package hot_100;

import java.util.PriorityQueue;

/**
 * @author weib
 * @date 2022-04-14 15:17
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 */
public class No_148_sorted_list {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {return a.val - b.val;});
        ListNode h = null;
        ListNode p = null;
        while (head != null) {
            pq.offer(head);
            head = head.next;
        }
        h = pq.poll();
        p = h;
        while(!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;
        }
        p.next = null;
        return h;
    }

}
