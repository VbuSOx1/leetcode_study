package recursion;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-05-18 10:24
 * https://leetcode-cn.com/problems/powx-n/
 * x^n
 * 思路：x^n = x^i * x^i …
 * 考虑怎么把n分出去 取n的平方根 若n的平方根还是很大 就继续求平方根
 *
 * 别人的思路：快速幂
 * 将幂二分
 *
 */
public class No50_Pow_x_n_ {

    public double myPow(double x, int n) {
        if(n < 0){
            x = 1 / x;
            n = -n;
        }
        return pow(x, n);
    }
    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double res = pow(x, n/2);
        // n是奇数
        if((n & 1) == 1){
            return res * res * x;
        }
        return res * res;

    }


    @Test
    public void tt(){
        System.out.println(myPow(2, -2));
    }
}



























