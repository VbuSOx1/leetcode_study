package Array_and_String;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-11-29 15:57
 * https://leetcode-cn.com/problems/array-partition-i/
 * 数组拆分shu'zu
 * 先排序 ,再取
 * 题目要求获得一个最大值，那就从最大的数开始取，由于min 最大的数娶不到，只能取比他小的数
 */
public class No561_Array_Partition_I {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            int num = nums[i];
            sum += num;
        }
        return sum;
    }
}
