package sword_offer;

import java.util.LinkedList;

/**
 * @author weib
 * @date 2021-12-02 21:34
 * 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class No_09 {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public No_09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
