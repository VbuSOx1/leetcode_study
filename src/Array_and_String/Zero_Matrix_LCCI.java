package Array_and_String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author weib
 * @date 2021-11-10 15:02
 * 0 矩阵
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 */
public class Zero_Matrix_LCCI {


    public void setZeroes(int[][] matrix) {
        // 表示 是否被 置为0  1表示是
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        // 遍历
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if(anInt != 0){
                    continue;
                }
                row.add(i);
                col.add(j);
            }
        }
        // 置0
        for (Integer i : row) {
            for (int ti = 0; ti < matrix.length; ti++) {
                matrix[i][ti] = 0;
            }
        }
        // 置0
        for (Integer j : col) {
            for (int ti = 0; ti < matrix[0].length; ti++) {
                matrix[ti][j] = 0;
            }
        }

    }
}
