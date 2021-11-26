package stack_and_queue;

import java.util.Stack;

/**
 * @author weib
 * @date 2021-06-06 14:48
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度，
 * 自己的思路： 暴力 同官方题解暴力 用一个数组或hash保存每一个温度出现的最小位置，然后反向遍历温度数组，，找到 hash中比这个温度大的
 * 所有的温度，以及他们的下标，找到下表最小的一个就行
 *
 * 更牛逼的思路：单调栈
 *
 */
public class No739_Daily_Temperatures {


    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.empty()){
                // 大于栈里的值
                if(temperatures[i] > temperatures[stack.peek()]){
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }else {
                    break;
                }
            }
            stack.push(i);
        }
        return ans;

    }
}
