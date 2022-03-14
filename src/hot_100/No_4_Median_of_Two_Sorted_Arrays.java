package hot_100;

/**
 * @author weib
 * @date 2022-03-14 15:18
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class No_4_Median_of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 数组长度和 是否偶数
        boolean oushu = (nums1.length + nums2.length) % 2 == 0;
        int target = (nums1.length + nums2.length) / 2;
        int i1 = 0;
        int i2 = 0;
        // 为0的条件
        // 当前查找值得 下标
        int curI = -1;
        int curV = 0;
        while(i1 < nums1.length && i2 < nums2.length){
            if (nums1[i1] < nums2[i2]) {
                curV = nums1[i1++];
            }
            else {
                curV = nums2[i2++];
            }
            curI++;
            if (oushu && curI == target-1) {
                if (i1 >= nums1.length){
                    return (curV + nums2[i2]) /(double) 2;
                }
                if (i2 >= nums2.length) {
                    return (curV + nums1[i1]) /(double) 2;
                }
                return (curV + Math.min(nums2[i2], nums1[i1])) /(double) 2;
            }
            if (!oushu && curI == target){
                return curV;
            }
        }
        if (i2 < nums2.length) {
            i1 = i2;
            nums1 = nums2;
        }
        while (i1 < nums1.length) {
            curI++;
            if (oushu && curI == target-1){
                return (nums1[i1] + nums1[i1+1])/(double)2;
            }
            if (!oushu && curI == target){
                return nums1[i1];
            }
            i1++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
