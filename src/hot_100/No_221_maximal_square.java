package hot_100;

import java.util.Arrays;

/**
 * @author weib
 * @date 2022-04-18 16:54
 * https://leetcode-cn.com/problems/maximal-square/
 * 221. 最大正方形
 */
public class No_221_maximal_square {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        int[][] maxDp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(maxDp[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                getMax(matrix, maxDp, i, j);
            }
        }

        return max;
    }

    public int getMax (char[][] matrix, int[][] maxDp, int i, int j) {
        if (i == matrix.length || j == matrix[0].length) {
            return 0;
        }
        if (maxDp[i][j] != -1) {
            return maxDp[i][j];
        }
        if (matrix[i][j] == '0') {
            maxDp[i][j] = 0;
            return 0;
        }
        int sub = getMax(matrix, maxDp, i+1, j+1) + 1;
        int right = getMax(matrix, maxDp, i, j+1) + 1;
        int down = getMax(matrix, maxDp, i+1, j) + 1;
        maxDp[i][j] = Math.min(sub, Math.min(right, down));
        if (max < maxDp[i][j] * maxDp[i][j]) {
            max =  maxDp[i][j] * maxDp[i][j];
        }
        return maxDp[i][j];
    }
}
