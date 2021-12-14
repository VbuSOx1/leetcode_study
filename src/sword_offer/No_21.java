package sword_offer;

/**
 * @author weib
 * @date 2021-12-14 11:17
 *  21. 调整数组顺序使奇数位于偶数前面
 *  https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class No_21 {
    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int o = nums.length;
        int j = -1;
        while (j < o) {
            while (++j < nums.length && nums[j] % 2 == 1);
            while (--o >= 0 && nums[o] % 2 == 0);
            if (j < o) {
                int n = nums[j];
                nums[j] = nums[o];
                nums[o] = n;
            }
        }
        return nums;
    }
}
