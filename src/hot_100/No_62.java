package hot_100;

import org.junit.Test;

/**
 * @author weib
 * @date 2022-03-30 11:54
 * https://leetcode-cn.com/problems/unique-paths/
 * 62. 不同路径
 */
public class No_62 {
    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        steps[m-1][n-1] = 1;
        return uniquePaths(0, 0, steps);
    }

    public int uniquePaths(int m, int n, int[][] steps){
        //m ==  -1 && n ==
        if (steps[m][n] != 0) {
            return steps[m][n];
        }
        // 右
        int right = 0;
        int down = 0;
        if (n < steps[0].length-1) {
            right = uniquePaths(m, n+1, steps);
        }
        // 下
        if (m < steps.length-1) {
            down = uniquePaths(m+1, n,steps);
        }
        steps[m][n] = right + down;
        return right + down;
    }

    @Test
    public void test(){
        System.out.println(uniquePaths(40,44));
    }
}
