package elementary_algorithm.array;

import java.util.Arrays;

/**
 * @author weib
 * @date 2020-12-16 10:00
 * https://leetcode-cn.com/problems/plus-one/
 *
 * 用递归
 */
public class No66_Plus_One {

    public int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if(digits[lastIndex] != 9){
            digits[lastIndex] += 1;
            return digits;
        }
        if(lastIndex == 0){
            return new int[]{1, 0};
        }
        digits[lastIndex] = 0;
        int[] d = Arrays.copyOfRange(digits, 0, lastIndex);
        d = plusOne(d);
        if(d.length == digits.length){
            // 长度 变长了
            int[] result = new int[d.length + 1];
            for(int i = 0; i < d.length; i++){
                result[i] = d[i];
            }
            result[d.length] = 0;
            return result;
        }
        for(int i = lastIndex - 1; i >= 0; i-- ){
            if(digits[i] != d[i]){
                digits[i] = d[i];
            }
            else {
                break;
            }
        }
        return digits;
    }
}
