package stack_and_queue;

import java.util.Stack;

/**
 * @author weib
 * @date 2021-06-21 14:46
 *
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * 用栈实现队
 */
public class No232_Implement_Queue_using_Stacks {




    class MyQueue {

        Stack<Integer> pushStack;
        Stack<Integer> popStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(popStack.isEmpty()){
                pushToPop();
            }
            return popStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(popStack.isEmpty()){
                pushToPop();
            }
            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }

        private void pushToPop(){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }
}





