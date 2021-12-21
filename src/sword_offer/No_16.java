package sword_offer;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-12-21 18:24
 * 16. 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * 注意测试用例：-2^31 这个直接转成正数是会出错的
 */
public class No_16 {
    HashMap<Long, Double> resultMap = new HashMap<>();
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1.0d;
        }
        long b = n;
        boolean symbol = n>0;
        b = symbol?b:-b;
        double result = calc(x, b);
        return symbol?result:1/result;
    }

    public double calc(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (resultMap.get(n) != null) {
            return resultMap.get(n);
        }
        double result = 0d;
        if (n % 2 == 0) {
            result = calc(x, n>>1) * calc(x, n>>1);
        }
        if (n % 2 == 1) {
            result = calc(x, n>>1) * calc(x, n>>1) * x;
        }
        resultMap.put(n, result);
        return result;
    }

    @Test
    public void test(){
        System.out.println(myPow(2, -2147483648));
    }
}
