package elementary_algorithm.other;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-05-14 23:13
 * 缺失数字
 * https://leetcode-cn.com/problems/missing-number/
 * 算总和 - 数组和
 * 处理溢出 ： 边加边减  异或
 */
public class No268_Missing_Number {
    public int missingNumber(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            sum += (i + 1);
        }
        return sum - count;
    }
}
