package Array_and_String;

/**
 * @author weib
 * @date 2021-11-29 21:08
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数相加2 输入有序数组
 *
 *  由于确定 数组中只有一对正确答案，那么设置双指针 在前后指针到达真确位置之前 移动指针，当一个指针到达真确位置之后移动另一个指针
 *  （为什么要这样做 那张纸画一画就知道了）
 */
public class No167_Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        indexs[0] = 0;
        indexs[1] = numbers.length - 1;
        while( indexs[0] < indexs[1]){
            int sum = numbers[indexs[0]] + numbers[indexs[1]];
            if(sum < target){
                indexs[0]++;
            }
            if(sum > target){
                indexs[1]--;
            }
            if(sum == target){
                indexs[0]++;
                indexs[1]++;
                return indexs;
            }
        }
        return null;
    }
}
