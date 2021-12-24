package sword_offer;

import java.util.HashMap;

/**
 * @author weib
 * @date 2021-12-24 15:28
 * 39. 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class No_39 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new  HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(nums[i]);
            if (v != null) {
                map.put(nums[i],v+1);
                if (v+1 > nums.length/2) {
                    return nums[i];
                }
                continue;
            }
            map.put(nums[i], 1);
        }
        return nums[0];
    }
}
