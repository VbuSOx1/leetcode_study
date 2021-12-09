package sword_offer;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-12-09 11:19
 * 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class No_10_I {
    int[] result = new int[101];
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (result[n] != 0) {
            return result[n];
        }
        result[n] = (fib(n - 1) + fib (n - 2)) % (1000000007);
        return result[n];
    }
    @Test
    public void test(){
        System.out.println(fib(100));
    }

}
