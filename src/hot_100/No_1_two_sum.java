package hot_100;

import java.util.HashMap;

/**
 * @author weib
 * @date 2022-03-14 10:12
 * // hash
 */
public class No_1_two_sum {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i=0; i < nums.length; i++) {
                Integer other = map.get(target - nums[i]);
                if (other != null) {
                    return new int[]{i,other};
                }
                map.put(nums[i], i);
            }
            return new int[]{0,1};
        }

    public static void main(String[] args) {
//        System.out.println(twoSum(new int[]{12,2}, 1)[0]);
    }
}
