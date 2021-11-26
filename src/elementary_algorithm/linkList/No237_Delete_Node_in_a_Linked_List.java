package elementary_algorithm.linkList;

/**
 * @author weib
 * @date 2021-04-02 15:50
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 删除链表中的一个节点，直接给删除的那个节点
 */
public class No237_Delete_Node_in_a_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
