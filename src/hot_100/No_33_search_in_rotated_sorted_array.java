package hot_100;

import java.util.Arrays;

/**
 * @author weib
 * @date 2022-03-18 9:46
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 33. 搜索旋转排序数组
 */
public class No_33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        int index = search(nums, 0, nums.length - 1, target);
        return index < 0 ? -1 : index;
    }

    public int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            if (nums[low] == target)
                return low;
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[low] < nums[mid]) {
            if (target <= nums[mid] && target >= nums[low]) {
                return Arrays.binarySearch(nums, low, mid+1, target);
            }
            return search(nums, mid+1, high, target);
        }
        if (target <= nums[high] && target >= nums[mid+1]) {
            return Arrays.binarySearch(nums, mid+1, high+1, target);
        }
        return search(nums, low, mid, target);
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
//        System.out.println(search(nums, 3));
    }
}
