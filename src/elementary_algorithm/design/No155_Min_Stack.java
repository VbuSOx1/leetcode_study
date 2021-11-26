package elementary_algorithm.design;

/**
 * @author weib
 * @date 2021-04-22 12:35
 * https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 *
 * 别人的思路：在StackNode 放一个min属性，代表这个节点之后的数中的最小值 就不用每次pop之后都计算最小值了
 */
public class No155_Min_Stack {
    public class StackNode{
        int val;
        StackNode next;
        StackNode(int val){this.val = val;}
        StackNode(){}
    };

    // 哨兵
    StackNode topStackNode;
    int minVal;
    int minValNum;

    /** initialize your data structure here. */
    public void MinStack() {
        topStackNode = new StackNode();
        minVal = Integer.MAX_VALUE;
        minValNum = 0;
    }

    public void push(int val) {
        StackNode newNode = new StackNode(val);
        newNode.next = topStackNode.next;
        topStackNode.next = newNode;
        if(val == minVal){
            minValNum++;
        }
        if(val < minVal){
            minVal = val;
            minValNum = 1;
        }
    }

    public void pop() {
        int curVal = topStackNode.next.val;
        topStackNode.next = topStackNode.next.next;
        if(curVal != minVal){
            return;
        }
        if(minValNum == 1){
            findMinVal();
        }else {
            minValNum--;
        }
    }

    public int top() {
        return topStackNode.next.val;
    }

    public int getMin() {
        return minVal;
    }

    public void findMinVal(){
        int min = Integer.MAX_VALUE;
        int minNum = 0;
        StackNode p = topStackNode.next;
        while(p != null){
            if(p.val == min){
                minNum++;
            }
            if(p.val < min){
                min = p.val;
                minNum = 1;
            }
            p = p.next;
        }
        minVal = min;
        minValNum = minNum;
    }
}
