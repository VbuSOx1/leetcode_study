package elementary_algorithm.array;

/**
 * @author weib
 * @date 2020-12-11 10:07
 * 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 *
 * 题目要求使用 线性时间， 不用额外空间
 * 首先想到的是快排 然后前后比较，但快排的时间复杂度是 nlogn
 * 在想到使用集合，集合的唯一特性可以解决，但需要额外空间
 * 最后看题解，学习到可以使用异或：
 *      主要应用 异或 运算的如下几个特性：
 *          n 异或 0 为 n
 *          n 异或 n 为 0
 *          异或满足交换律和结合律（关键点） 把相同的两个值交换在一起，最后式子就成了  0 异或 n  最后的 n 就是 只出现一次的数字
 */
public class No136_SingleNumber {

    public int singleNumber(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] ^ nums[i-1];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {

    }


}
