package hot_100;

import java.util.Arrays;

/**
 * @author weib
 * @date 2022-03-31 16:11
 * minimum-path-sum
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 64. 最小路径和
 * dp
 */
public class No_64_minimum_path_sum {
    public int minPathSum(int[][] grid) {
        int[][] minMatrx = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            Arrays.fill(minMatrx[i], -1);
        }
        minMatrx[0][0] = grid[0][0];
        return getMinStep(grid.length-1, grid[0].length-1, grid, minMatrx);
    }

    public int getMinStep(int i, int j, int[][] grid, int[][] minMatrx) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(minMatrx[i][j] != -1) {
            return minMatrx[i][j];
        }
        minMatrx[i][j] = Math.min(getMinStep(i-1, j, grid, minMatrx), getMinStep(i, j-1, grid, minMatrx)) + grid[i][j];
        return minMatrx[i][j];
    }
}
