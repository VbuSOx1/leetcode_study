package Array_and_String;

/**
 * @author weib
 * @date 2021-12-01 15:43
 * 724. Find Pivot Index
 * 数组中心下标
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
public class No724_Find_Pivot_Index {
    // 边界问题要考虑全
    public int pivotIndex(int[] nums) {
        int pivIndex = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++){
            rightSum += nums[i];
        }
        while (pivIndex < nums.length){
            if (leftSum == rightSum){
                return pivIndex;
            }
            leftSum += nums[pivIndex];
            pivIndex++;
            if (pivIndex >= nums.length){
                return -1;
            }
            rightSum -= nums[pivIndex];
        }
        return -1;

    }
}
