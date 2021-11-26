package stack_and_queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-05-28 9:56
 * https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿数量
 * 遍历数组  判断左上是不是有 1 有1岛屿数量不变 无一岛屿加1 不对不对
 *
 * 这题不会 看题解  应该用dfs 去遍历 把联通的全部变成0
 *
 */
public class No200_Number_of_Islands {

        public int numIslands(char[][] grid) {
            int num = 0;
            boolean newIsland = true;
            // 行
            for (int i = 0; i < grid.length; i++){
                // 列
                for (int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == '0'){
                        continue;
                    }
                    newIsland = true;
                    // 判断上 下 左  右
                    if((i > 0 && grid[i-1][j] == '1')
                        || (j > 0 && grid[i][j-1] == '1')
                        || (i < grid.length-1 && grid[i+1][j] == '1')
                        || (j < grid[i].length -1 && grid[i][j+1] == '1')){
                        newIsland = false;
                    }
                    if(newIsland){
                        num++;
                    }
                }
            }
            return num;
        }



        @Test
        public void test(){
            char[][] abs = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
            System.out.println(numIslands(abs));
        }


        // 官方题解
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;

            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        grid[r][c] = '0';
                        Queue<Integer> neighbors = new LinkedList<>();
                        neighbors.add(r * nc + c);
                        while (!neighbors.isEmpty()) {
                            int id = neighbors.remove();
                            int row = id / nc;
                            int col = id % nc;
                            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                                neighbors.add((row-1) * nc + col);
                                grid[row-1][col] = '0';
                            }
                            if (row + 1 < nr && grid[row+1][col] == '1') {
                                neighbors.add((row+1) * nc + col);
                                grid[row+1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                                neighbors.add(row * nc + col-1);
                                grid[row][col-1] = '0';
                            }
                            if (col + 1 < nc && grid[row][col+1] == '1') {
                                neighbors.add(row * nc + col+1);
                                grid[row][col+1] = '0';
                            }
                        }
                    }
                }
            }

            return num_islands;
        }
    }


}
