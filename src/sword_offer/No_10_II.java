package sword_offer;

/**
 * @author weib
 * @date 2021-12-09 11:47
 * 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class No_10_II {
    int[] result = new int[101];
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (result[n] != 0) {
            return result[n];
        }
        result[n] = (numWays(n - 1) + numWays (n - 2)) % (1000000007);
        return result[n];
    }
}
