package elementary_algorithm.BP;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-04-20 13:21
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 */
public class No053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else // 只要sum 大于0 那么它对于后面的数来说都有一个正增益
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {4, -1 ,5};
        System.out.println(maxSubArray(nums));
    }
}
