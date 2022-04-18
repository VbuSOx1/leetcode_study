package hot_100;

import java.util.Arrays;

/**
 * @author weib
 * @date 2022-03-18 10:47
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 二分
 */
public class No_34 {
    public int[] searchRange(int[] nums, int target) {
        int mid = Arrays.binarySearch(nums, target);
        if (mid < 0) {
            return new int[]{-1, -1};
        }
        int left = mid;
        int leftMid = mid;
        while (true) {
            int index = Arrays.binarySearch(nums, 0, leftMid,target);
            if (index >=0 ){
                left = index;
                leftMid = index;
            } else {
                break;
            }
        }
        int right = mid;
        int rightMid = mid+1;
        while (true) {
            int index = Arrays.binarySearch(nums, rightMid, nums.length,target);
            if (index >=0 ){
                right = index;
                rightMid = index+1;
            } else {
                break;
            }
        }
        return new int[]{left, right};
    }
}
