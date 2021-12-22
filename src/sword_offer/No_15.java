package sword_offer;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-12-22 10:35
 * 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * 注意负数以补码的形式存在计算机中
 */
public class No_15 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    @Test
    public void test(){
        int a = -3;
        System.out.println(Integer.toBinaryString(a));
        a >>= 1;
        System.out.println(Integer.toBinaryString(a));
        a >>= 1;
        System.out.println(Integer.toBinaryString(a));
    }
}
