package sword_offer;

/**
 * @author weib
 * @date 2022-01-05 10:13
 *  14- II. 剪绳子 II
 *  https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */
public class No_14_II {
    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }
}
