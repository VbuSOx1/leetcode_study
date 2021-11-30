package elementary_algorithm.design;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author weib
 * @date 2021-04-22 10:24
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * 打乱数组
 */
public class No384_Shuffle_an_Array {

    Random random = new Random();
    int[] nums;

    public void Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] numsClone = new int[nums.length];
        boolean[] isUse = new boolean[nums.length];
        for(int i = 0; i < numsClone.length; ){
            int curIndex = random.nextInt(nums.length);
            if(isUse[curIndex]){
                continue;
            }
            numsClone[i++] = nums[curIndex];
            isUse[curIndex] = true;
        }
        return numsClone;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 4, 5};
        Solution(nums);
        System.out.println(Arrays.toString(shuffle()));
        System.out.println(Arrays.toString(reset()));
        System.out.println(Arrays.toString(shuffle()));

    }


}
