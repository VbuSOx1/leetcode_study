package sword_offer;

/**
 * @author weib
 * @date 2021-12-23 15:04
 * 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 水王
 */
public class No_56_II {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            while (nums[i] > 0) {
                bits[index++] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        int p = 1;
        int result = 0;
        for (int i = 0; i < bits.length; i++) {
            bits[i] %= 3;
            result += bits[i] * p;
            p <<= 1;
        }
        return result;
    }
}
