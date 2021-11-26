package elementary_algorithm.array;

/**
 * @author weib
 * @date 2020-12-17 10:07
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 */
public class No283_Move_Zeroes {

    /**
     * 双指针 从数组尾部出发（保证有序），一个找0， 一个找非零，然后交换位置
     * 这是错误答案:
     * {0, 1, 0, 3, 12} ==> [3, 1, 12, 0, 0]
     * 没有保证原序列顺序
     * @param nums
     */
    @Deprecated
    public void moveZeroes1(int[] nums) {
        int zeroPoint = nums.length - 1;
        int nonZeroPoint = zeroPoint;
        while(true){
            while(zeroPoint >= 0 && nums[zeroPoint] != 0) {zeroPoint--;}
            while(nonZeroPoint >= 0 && nums[nonZeroPoint] == 0) {nonZeroPoint--;}
            if(zeroPoint < 0 || nonZeroPoint < 0){
                break;
            }
            if(zeroPoint < nonZeroPoint){
                int temp = nums[zeroPoint];
                nums[zeroPoint] = nums[nonZeroPoint];
                nums[nonZeroPoint] = temp;
            }
        }
    }

    /**
     * 正确答案：
     * 一个指针，一个记录count（初始为0，找到一个0就 count++）， 指针往后移动，每到一个新的元素，
     * 就把元素往前移动count次
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int count = 0;
        int point = -1;
        int length = nums.length;
        while(++point < length){
            if(nums[point] == 0){
                count++;
                continue;
            }
            nums[point - count] = nums[point];
        }
        while(count-- > 0){
            nums[--length] = 0;
        }
    }






}
