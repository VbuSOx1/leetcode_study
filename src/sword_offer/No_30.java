package sword_offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author weib
 * @date 2021-12-02 21:41\
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 包含min函数的栈
 *
 * 更好的思路， 空间换时间
 * 给每个节点多加一个属性 保存当前最小值
 */
public class No_30 {

    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    int minNum = 1;
    /** initialize your data structure here. */
    public No_30() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (x == min){
            minNum++;
        }
        if (x < min){
            min = x;
            minNum = 1;
        }
    }

    public void pop() {
        int v = stack.pop();
        if (stack.isEmpty()){
            min = Integer.MAX_VALUE;
            minNum = 1;
        }
        // 重算 min
        if (v == min && --minNum < 1 ){
            Integer[] vals =  Arrays.copyOf(stack.toArray(), stack.size(), Integer[].class);
            min = Integer.MAX_VALUE;
            for (Integer val : vals ){
                if (val < min){
                    min = val;
                    minNum = 1;
                }else if (val == min){
                    minNum ++;
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
