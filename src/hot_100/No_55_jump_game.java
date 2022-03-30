package hot_100;

/**
 * @author weib
 * @date 2022-03-22 14:21
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * 从后往前找0
 */
public class No_55_jump_game {
    public static boolean canJump(int[] nums) {
        // 找 0
        if (nums.length == 1) {
            return true;
        }

        for (int i = nums.length-1; i >=0 ; i--){
            if (nums[i] != 0) {
                continue;
            }
            int j = 0;
            for (j = i-1; j >= 0; j--) {
                if (nums[j] > i - j || (nums[j] == i-j && i == nums.length-1)){
                    i = j;
                    break;
                }
            }
            if (j == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(No_55_jump_game.class.getClassLoader());
    }
}
