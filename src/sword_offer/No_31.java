package sword_offer;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author weib
 * @date 2021-12-29 12:03
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 *  31. 栈的压入、弹出序列
 *  看官方题解 自己写的太复杂了
 *  如果发现做的时间特别长 那就不要继续想了 思路很可能有问题 直接看答案就行 节约时间
 */
public class No_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> curStack = new ArrayList<>();
        Map<Integer, Integer> pushMap = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            pushMap.put(pushed[i], i);
        }
        int start = -1;
        for (int i = 0; i < popped.length; i++) {
            int index = pushMap.get(popped[i]);
            if (index < start) {
                if (curStack.indexOf(popped[i]) < curStack.size()-1) {
                    return false;
                }
                curStack.remove(curStack.size()-1);
                continue;
            }
            for (int j = start+1; j <= index; j++) {
                curStack.add(pushed[j]);
            }
            curStack.remove(curStack.size()-1);
            start = index;
        }
        return true;
    }


    /**
     * 官方题解 清晰明了
     * @param pushed
     * @param popped
     * @return
     */

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test(){
       int[] pushed = {1,0};
       int[] popped = {1,0};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
