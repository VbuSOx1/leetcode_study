package sword_offer;

/**
 * @author weib
 * @date 2021-12-25 20:47
 * 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 数学题目
 */
public class No_14_I {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
