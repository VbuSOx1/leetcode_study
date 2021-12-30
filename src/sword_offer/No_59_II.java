package sword_offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-12-30 12:03
 * 59 - II. 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * 单调队列
 */
public class No_59_II {

    class MaxQueue {
        Deque<Integer> deque;
        Queue<Integer> queue;

        public MaxQueue() {
            deque = new LinkedList();
            queue = new LinkedList();
        }

        public int max_value() {
            return deque.isEmpty()?-1:deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() &&  value > deque.peekLast()) {
                deque.removeLast();
            }
            deque.offer(value);
        }

        public int pop_front() {
            if (deque.isEmpty()) {
                return -1;
            }
            int front = queue.poll();
            if (front == deque.peekFirst()) {
                deque.removeFirst();
            }
            return front;
        }
    }
}
