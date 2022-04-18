package hot_100;

import java.util.HashMap;

/**
 * @author weib
 * @date 2022-04-13 16:06
 * 146. LRU 缓存
 * https://leetcode-cn.com/problems/lru-cache/
 * 双向链表 + hashmap
 * hashmap 就是cache本身  双向链表的顺序就是最近使用--最久未使用
 */
public class No_146_LRUCache {
    class LRUCache {

        class DeLinkedNode {
            int key;
            int value;
            DeLinkedNode pre;
            DeLinkedNode next;
            DeLinkedNode(){}
            DeLinkedNode(int key, int value){
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, DeLinkedNode> cache;
        private DeLinkedNode head;
        private DeLinkedNode tail;
        int capacity;
        int size;

        public LRUCache() {
            cache = new HashMap<>();
            head = new DeLinkedNode();
            tail = new DeLinkedNode();
            head.next = tail;
            tail.pre = head;
            size = 0;
            capacity = 16;
        }

        public LRUCache(int capacity) {
            this();
            this.capacity = capacity;
        }

        public int get(int key) {
            DeLinkedNode node = cache.get(key);
            if (node != null) {
                moveTohead(node);
                return node.value;
            }
            return -1;

        }

        public void put(int key, int value) {
            DeLinkedNode node = cache.get(key);
            if (node != null) {
                moveTohead(node);
                node.value = value;
                return;
            }
            node = new DeLinkedNode(key, value);
            addToHead(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                cache.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }
        }


        private void removeNode(DeLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(DeLinkedNode node) {
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
        }

        private void moveTohead(DeLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }
    }
}
