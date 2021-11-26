package recursion;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-05-17 16:54
 * 斐波那契数列
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class No509_Fibonacci_Number {

    int fib[] = new int[31];
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(fib[n] != 0){
            return fib[n];
        }
        fib[n] = fib(n - 1) + fib(n - 2);
        return fib[n];
    }
}
