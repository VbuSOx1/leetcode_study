package sword_offer;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-12-15 11:11
 * 13 机器人运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 */
public class No_13 {

    public int movingCount(int m, int n, int k) {
        boolean visit[][] = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visit);
    }

    public int dfs(int m, int n, int x, int y, int k,  boolean visit[][]) {
        // 不符合条件
        if ( x < 0 || y < 0 || x >= m || y >= n || visit[x][y] || numSum(x, y) > k){
            return 0;
        }
        visit[x][y] = true;
        int max = dfs(m, n, x-1, y, k, visit) + dfs(m, n, x+1, y, k, visit) +
                dfs(m, n, x, y-1, k, visit) + dfs(m, n, x, y+1, k, visit)+ 1;
        return max;
    }

    // 数字和
    public int numSum(int x, int y) {
        int sum = 0;
        // 个位 10wei  bai wei
        sum += (x % 10 + x / 10 % 10 + x / 100 % 10);
        sum += (y % 10 + y / 10 % 10 + y / 100 % 10);
        return sum;
    }

    @Test
    public void test(){
        System.out.println(movingCount(7,2 ,3));
    }
}
