package stack_and_queue;

/**
 * @author weib
 * @date 2021-05-25 22:06
 * https://leetcode-cn.com/problems/design-circular-queue/
 * 设计循环队列
 */
public class No622_Design_Circular_Queue {

    class MyCircularQueue {
        private QueueNode front;
        private QueueNode rear;
        private int maxNodeNum;
        private int curNodeNum;
        class QueueNode{
            int value;
            QueueNode next;
            QueueNode(int v, QueueNode n){
                value = v;
                next = n;
            }
        }

        public MyCircularQueue(int k) {
            maxNodeNum = k;
            curNodeNum = 0;
        }

        public boolean enQueue(int value) {
            if(curNodeNum >= maxNodeNum){
                return false;
            }
            QueueNode node = new QueueNode(value, front);
            curNodeNum++;
            if(curNodeNum == 1){
                front = node;
                rear = node;
            }
            rear.next = node;
            rear = node;
            return true;
        }

        public boolean deQueue() {
            if(curNodeNum < 1){
                return false;
            }
            if(curNodeNum == 1){
                curNodeNum = 0;
                front = null;
                rear = null;
                return true;
            }
            front = front.next;
            rear.next = front;
            curNodeNum--;
            return true;
        }

        public int Front() {
            if(curNodeNum > 0){
                return front.value;
            }
            return -1;
        }

        public int Rear() {
            if(curNodeNum > 0){
                return rear.value;
            }
            return -1;

        }

        public boolean isEmpty() {
            if(curNodeNum < 1){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if(curNodeNum >= maxNodeNum){
                return true;
            }
            return false;
        }
    }
}
