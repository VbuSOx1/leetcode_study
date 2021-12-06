package sword_offer;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-12-06 14:16
 *  03. 数组中重复的数字
 *  https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class No_03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            Integer index = map.get(nums[i]);
            if (index != null){
                return index;
            }
            map.put(nums[i], nums[i]);
        }
        return 0;
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length - 1; i++){
        //     if (nums[i] == nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // return 0;
    }
}
