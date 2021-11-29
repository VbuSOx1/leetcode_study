package Array_and_String;

/**
 * @author weib
 * @date 2021-11-29 21:34
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 * 最大连续1
 */
public class No485_Max_Consecutive_Ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = 0;
        int max = 0;
        for (int num : nums) {
            if(num == 1){
                n += 1;
            }else {
                if(n > max){
                    max = n;
                }
                n = 0;
            }
        }
        return Math.max(n, max);
    }
}
