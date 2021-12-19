package sword_offer;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-12-19 21:37
 * 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class No_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr,  0, k);
    }
}
