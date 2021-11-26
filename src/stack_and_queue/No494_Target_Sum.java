package stack_and_queue;

/**
 * @author weib
 * @date 2021-06-20 14:04
 * https://leetcode-cn.com/problems/target-sum/
 * https://leetcode-cn.com/problems/target-sum/
 *
 * 目标和  回溯（DFS）
 */
public class No494_Target_Sum {



    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {

        dfs(nums, 0, target, 0);
        return  count;
    }



    public void dfs(int[] nums, int index, int target, int sum){
        if(index == nums.length){
            if(target == sum){
                count ++;
            }
            return;
        }
        dfs(nums, index + 1, target, sum + nums[index]);
        dfs(nums, index + 1, target, sum - nums[index]);
    }







}
