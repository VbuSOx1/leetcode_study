package sword_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author weib
 * @date 2021-12-03 12:53
 * 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class No_06 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while(p != null){
            list.add(p.val);
            p = p.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
