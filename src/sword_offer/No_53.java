package sword_offer;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-12-06 19:00
 * 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class No_53 {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return 0;
        }
        int sum = 1;
        for (int p = index - 1; p >= 0; p--){
            if (nums[p] == target){
                sum++;
            }else{
                break;
            }
        }
        for (int q = index + 1; q < nums.length; q++){
            if (nums[q] == target){
                sum++;
            }else{
                break;
            }
        }
        return sum;
    }
}
