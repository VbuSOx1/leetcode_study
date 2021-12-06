package sword_offer;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-12-06 13:01
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 复杂链表的复制、、
 * 还有一种方法 ： in place
 */
public class No_35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node result = new Node(head.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, result);
        Node rp = result;
        Node hp = head.next;
        while (hp != null) {
            rp.next = new Node(hp.val);
            rp = rp.next;
            map.put(hp, rp);
            hp = hp.next;
        }
        rp = result;
        hp = head;
        while (hp != null){
            rp.random = map.get(hp.random);
            rp = rp.next;
            hp = hp.next;
        }
        return result;
    }

    /**
     * 别人的方法 in place
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
        for (Node node = head, copy = null; node != null; node = node.next.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }
        //把拷贝节点的random指针安排上
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }
        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
        Node newHead = head.next;
        for (Node node = head, temp = null; node != null && node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }

        return newHead;
    }
}
