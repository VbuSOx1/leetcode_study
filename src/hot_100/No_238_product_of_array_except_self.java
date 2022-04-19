package hot_100;

/**
 * @author weib
 * @date 2022-04-19 10:21
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 238. 除自身以外数组的乘积
 * dp
 */
public class No_238_product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        getRightMul(nums, dp, 1, 0);
        return dp;
    }

    public int getRightMul(int[] nums, int[] dp, int left, int i) {
        if (i == nums.length) {
            return 1;
        }
        int right = getRightMul(nums, dp, left*nums[i], i+1);
        dp[i] = left * right;
        return right * nums[i];
    }
}
