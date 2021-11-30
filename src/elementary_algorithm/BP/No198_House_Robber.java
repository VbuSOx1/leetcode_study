package elementary_algorithm.BP;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-04-21 13:36
 * https://leetcode-cn.com/problems/house-robber/
 * 打家劫舍
 */
public class No198_House_Robber {

    public int rob(int[] nums) {
        int pre = nums[0];
        int prePre = 0;
        if(nums.length == 1){
            return nums[0];
        }
        int k = 1;
        int result = 0;
        while(k < nums.length){
            result = Math.max(pre, prePre + nums[k]);
            k++;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    @Test
    public void test(){

        int[] nums = {2,1,1,3,1};
        System.out.println(rob(nums));
    }
}
