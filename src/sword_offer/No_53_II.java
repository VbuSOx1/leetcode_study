package sword_offer;

/**
 * @author weib
 * @date 2021-12-07 16:26
 * 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class No_53_II {
    public int missingNumber(int[] nums) {
    int i = 0;
    while (i < nums.length){
        if (i != nums[i]) {
            return i;
        }
        i++;
    }
    return nums.length;
}
}
