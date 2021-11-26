package elementary_algorithm.other;

import org.junit.jupiter.api.Test;

/**
 * @author weib
 * @date 2021-04-30 22:23
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 1的位数
 *
 * 位运算
 */
public class No191_Number_of_1_Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int t = n;
        int count = t & 1;
        t = t >>> 1;
        while(t > 0){
            if((t & 1) == 1){
                count++;
            }
            t = t >>> 1;
        }
        return count;
    }


    @Test
    public void test(){
        System.out.println(hammingWeight(11));
    }
}
