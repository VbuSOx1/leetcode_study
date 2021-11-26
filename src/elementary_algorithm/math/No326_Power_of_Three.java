package elementary_algorithm.math;

/**
 * @author weib
 * @date 2021-04-25 21:31
 * https://leetcode-cn.com/problems/power-of-three/
 * 3的幂
 */
public class No326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        long i = 3;
        while(i < n){
            i *= 3;
        }
        if(i == n){
            return true;
        }
        return false;
    }
}
