package stack_and_queue;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-10-12 15:37
 * https://leetcode-cn.com/problems/01-matrix/
 * 这个题最开始用的是 dfs (动态规划) 但是总有几个测试用例过不去（原因是，我在处理可能重复走动的方式出了问题，
 *  每一次走动其实只能往两个方向上动，不是四个方向）
 *  或者 bfs
 */
public class No542_01_Matrix {

    static int[][] visit;
    static int r = 1;
    public static int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        visit = new int[mat.length][mat[0].length];
        for (int[] ints : result) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < result.length; i++) {
            int[] ints = result[i];
            for (int j = 0; j < ints.length; j++) {
                for (int[] v : visit) {
                    Arrays.fill(v, -1);
                }
                if (result[i][j] == -1) {
                    dfs(mat, i, j, result);
                }
            }
        }
        return result;
    }


    public static int dfs(int[][] mat, int x, int y, int[][] result) {
        if (x < 0 || y < 0 || x >= result.length || y >= result[0].length) {
            return Integer.MAX_VALUE;
        }
        if (visit[x][y] == 1) {
            return Integer.MAX_VALUE;
        }
        if (result[x][y] != -1) {
            return result[x][y];
        }
        if (mat[x][y] == 0) {
            result[x][y] = 0;
            return 0;
        }
        visit[x][y] = 1;
        int up = dfs(mat, x, y - 1, result);
        int down = dfs(mat, x, y + 1, result);
        int left = dfs(mat, x - 1, y, result);
        int right = dfs(mat, x + 1, y, result);
        int less = Math.min(Math.min(up, down), Math.min(left, right));
        result[x][y] = less + 1;
        return less + 1;
    }






    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = updateMatrix(mat);

        for (int[] ints : result) {
//            Arrays.fill(ints, -1);
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
