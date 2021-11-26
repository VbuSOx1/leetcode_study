package elementary_algorithm.BP;

/**
 * @author weib
 * @date 2021-04-19 19:08
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 *
 * 动态规划
 */
public class No070_Climbing_Stairs {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
