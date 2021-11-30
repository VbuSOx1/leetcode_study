package Array_and_String;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author weib
 * @date 2021-11-30 10:32
 * https://leetcode-cn.com/leetbook/read/array-and-string/c0w4r/
 * 长度最小的子数组和
 * 先排序 在减最大的 (错误 不能排序，题目要求 连续子数组)
 */
public class No209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            target -= num;
            count++;
            if(target <= 0){
                return count;
            }
        }
        return 0;
    }

    /**
     * 找到第一个 满足目标的区间（长度n） 然后从该区间右边+1个元素，在依次往左数(n-1)个 看是否满足条件，如果满足 则找到更小的区间
     * 再从这个区间按上面步骤依次往右找 直到区间大小为1
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int left = -1;
        int right = -1;
        int min_step = Integer.MAX_VALUE;
        boolean find = false;
        while(right < len){
            int sum = 0;
            for (int i = right + 1, b = 1; i < len && i >=0 && b < min_step; i--, b++) {
                sum += nums[i];
                if (sum >= target){
                    min_step = b;
                    find = true;
                    break;
                }
            }
            right++;
        }
        return find?min_step:0;
    }

    /**
     * 别人的代码
     * 我的解法相当于暴力了 ，每一次计算区间会进行重复计算
     * 但实际上只需要用sum减掉舍弃的部分就行
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen3(int target, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= target) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    @Test
    public void test(){
        int[] a = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen2(213, a));
    }
}
