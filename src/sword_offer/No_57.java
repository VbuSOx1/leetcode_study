package sword_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weib
 * @date 2021-12-14 15:03
 *  57. 和为s的两个数字
 *  https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class No_57 {
    // hash
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> nset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            nset.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nset.contains(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
        }
        return new int[]{};
    }
    // 双指针
    public int[] twoSum2(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while(left < right){

            if(nums[left] + nums[right] < target)left++;
            else if(nums[left] + nums[right] > target)right--;
            else return new int[] {nums[left], nums[right]};

        }
        return new int[0];

    }
}
