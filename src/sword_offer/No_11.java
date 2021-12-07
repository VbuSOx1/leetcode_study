package sword_offer;

/**
 * @author weib
 * @date 2021-12-07 20:59
 *  旋转数组的最小数字
 *  https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class No_11 {
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }
}
