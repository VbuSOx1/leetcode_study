package hot_100;

/**
 * @author weib
 * @date 2022-03-17 16:48
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * z找规律：从右往左找第一个小于右边的数， 然后把右边的数翻转（升序），找第一个大于这个数的数，交换位置
 */
public class No_31_next_permutation {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (nums.length < 3) {
            reverse(nums, 0, length - 1);
            return ;
        }
        int i = length - 2;
        while (i >= 0){
            if (nums[i] >= nums[i+1] ){
                i--;
                continue;
            }
            reverse(nums, i+1, length-1);
            for (int j = i+1; j <= length -1; j++){
                if (nums[j] > nums[i] ){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    return ;
                }
            }
        }
        if (i < 0) {
            reverse(nums, 0, length - 1);
        }
    }

    public void reverse(int[] nums, int startIndex, int endIndex)  {
        int temp = 0;
        while (startIndex < endIndex) {
            temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
