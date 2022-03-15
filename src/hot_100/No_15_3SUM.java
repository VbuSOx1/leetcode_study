package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weib
 * @date 2022-03-15 16:37
 * https://leetcode-cn.com/problems/3sum/submissions/
 * 15. 三数之和
 * 排序双指针
 */
public class No_15_3SUM {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        // 目标 a + b + c == 0
        int a = 0;
        int b = 0;
        int c = 0;
        for (int first = 0; first < nums.length -1 ;first ++) {
            if (first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            a = nums[first];
            int target = -a;
            int third = nums.length -1;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                b = nums[second];
                c = nums[third];
                while (third > second && a + b + c > 0) {
                    third--;
                    c = nums[third];
                }
                // 这一句是核心，降低复杂度
                if (third == second) {
                    break;
                }
                if (a + b + c == 0) {
                    result.add(Arrays.stream(new int[]{a, b, c}).boxed().collect(Collectors.toList()));
                }
            }
        }
        return result;

    }
}
