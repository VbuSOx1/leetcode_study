package hot_100;

/**
 * @author weib
 * @date 2022-04-19 15:42
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 287. 寻找重复数
 * 快慢指针

 */
public class No_287_find_the_mul_number {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
