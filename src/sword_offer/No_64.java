package sword_offer;

/**
 * @author weib
 * @date 2021-12-20 15:10
 *  64. 求1+2+…+n
 *  https://leetcode-cn.com/problems/qiu-12n-lcof/
 *  数学题
 */
public class No_64 {
    public int sumNums(int n) {
        return ((int)Math.pow(n,2)+n)>>1;

    }
}
