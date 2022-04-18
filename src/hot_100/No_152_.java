package hot_100;

/**
 * @author weib
 * @date 2022-04-14 16:57
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 152. 乘积最大子数组
 * 动态规划
 */
public class No_152_ {
    public int maxProduct(int[] nums) {
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        maxs[0] = nums[0];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxs[i] = Math.max(maxs[i-1] * nums[i], nums[i]);
                mins[i] = Math.min(mins[i-1] * nums[i], nums[i]);
                continue;
            }
            if (nums[i] < 0) {
                maxs[i] = Math.max(mins[i-1] * nums[i], nums[i]);
                mins[i] = Math.min(maxs[i-1] * nums[i], nums[i]);
                continue;
            }
            if (nums[i] == 0) {
                maxs[i] = 0;
                mins[i] = 0;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < maxs.length; i++)
        {
            max = Math.max(max, maxs[i]);
        }
        return max;
    }
}
