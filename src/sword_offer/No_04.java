package sword_offer;

import java.util.Arrays;

/**
 * @author weib
 * @date 2021-12-07 16:46
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 04. 二维数组中的查找
 */
public class No_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //
        int max_row = 0;
        for (int i = matrix.length - 1; i >= 0; i--){
            if (matrix[i][0] == target){
                return true;
            }
            if (matrix[i][0] > target){
                continue;
            }
            max_row = i;
            break;
        }
        return Arrays.binarySearch(matrix[max_row], target)>-1;
    }
}
