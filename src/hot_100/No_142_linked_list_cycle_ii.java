package hot_100;

import java.util.HashSet;

/**
 * @author weib
 * @date 2022-04-13 14:46
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class No_142_linked_list_cycle_ii {
    
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode f = head;
        while (f != null) {
            if (set.contains(f)) {
                return f;
            }
            set.add(f);
            f = f.next;
        }
        return null;
    }
}
