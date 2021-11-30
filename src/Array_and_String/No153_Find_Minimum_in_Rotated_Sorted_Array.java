package Array_and_String;

/**
 * @author weib
 * @date 2021-11-30 21:38
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 寻找旋转排序数组中的最小值
 */
public class No153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int len = nums.length;
        int index = 0;
        if (len == 1){
            return nums[0];
        }
        if (len == 2){
            return Math.min(nums[0], nums[1]);
        }
        while(true){
            // 前面的索引
            int befIndex = (index - 1 + len) % len;
            int aftIndex = (index + 1 )% len;
            if(nums[index] < nums[aftIndex] && nums[index] < nums[befIndex]){
                return nums[index];
            }
            if(nums[index] < nums[aftIndex]){
                index = befIndex;
            }else{
                index = aftIndex;
            }
        }
    }
}
