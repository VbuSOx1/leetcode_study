package sword_offer;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-12-19 21:33
 * 61. 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class No_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count0 = 0;
        int i = 0;
        while(nums[i++] == 0){count0++;};
        while(i < 5){
            int diff = nums[i] - nums[i-1];
            i++;
            if (diff == 1){
                continue;
            }
            if (diff <= 0 ){
                return false;
            }
            count0 -= (diff - 1);
            if (count0 < 0){
                return false;
            }
        }
        return true;
    }
}
