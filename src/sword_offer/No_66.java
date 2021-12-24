package sword_offer;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-12-24 15:55
 * 66 构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class No_66 {
    public int[] constructArr(int[] a) {
        if (a == null) {
            return new int[]{0};
        }
        int[] b = new int[a.length];
        Arrays.fill(b, 1);
        int temp = 1;
        // 计算之前的
        for (int i = 1; i < a.length; i++) {
            b[i] = a[i-1] * b[i-1];
        }
        for (int i = a.length-2; i >= 0; i--) {
            temp *= a[i+1];
            b[i] *= temp;
        }
        return b;
    }
}
