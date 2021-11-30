package stack_and_queue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author weib
 * @date 2021-06-02 16:06
 * https://leetcode-cn.com/problems/perfect-squares/
 * 完全平方数
 *
 * 思路: 从大到小找完全平方数, 思路错误: 这种算是贪心, 但不能找到最优解
 * 思路2: 动态规划: 对不同平方数取余, 然后计算余数的完全平方数个数 , 取个数最小的(也不是动态规划,动态规划会保存1-n的结果,
 *        这个思路是贪心 + DFS )
 */
public class No279_Perfect_Squares {

    HashMap<Integer, Integer> minNum = new HashMap<>();
    public int numSquares(int n) {
        if(minNum.get(n) != null){
            return minNum.get(n);
        }
        Stack<Integer> ps = new Stack<>();
        for(int i = 1; i*i <= n; i++){
            ps.add(i*i);
        }
        int minCount = Integer.MAX_VALUE;
        while(!ps.empty()){
            int count = 0;
            int curPs = ps.pop();
            count += n/curPs;
            if(n%curPs != 0){
                count += numSquares(n%curPs);
            }
            if(count < minCount){
                minCount = count;
            }
        }
        minNum.put(n, minCount);
        return minCount;
    }

    @Test
    void testt(){
        System.out.println(numSquares(43));
    }
}
