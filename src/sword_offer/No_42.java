package sword_offer;

/**
 * @author weib
 * @date 2021-12-10 11:39
 * 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class No_42 {
    public int maxSubArray(int[] nums) {
        int max = -101;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;

    }
}
