package Array_and_String;

/**
 * @author weib
 * @date 2021-11-18 17:21
 * 对角线遍历
 * https://leetcode-cn.com/problems/diagonal-traverse/
 */
public class No498_Diagonal_Traverse {

    public static int[] findDiagonalOrder(int[][] mat) {
        int max_i = mat.length;
        int max_j = mat[0].length;
        int[] result = new int[max_i*max_j];
        result[0] = mat[0][0];
        int i = 0;
        int j = 0;
        // 只有一行
        if( max_i == 1){
            for (int k = 0; k < result.length; k++) {
                result[k] = mat[0][k];
            }
            return result;
        }
        // 只有一列
        if (max_j == 1){
            for (int k = 0; k < result.length; k++) {
                result[k] = mat[k][0];
            }
            return result;
        }
        // 这一步要上移  不是上移就是下
        boolean up = true;
        // 这一步要移边  不是移边就是斜着移动
        boolean e_move = true;

        for (int d = 1; d < result.length; d++) {
            // 右移
            if((i == 0 || i == max_i-1) && e_move && j != max_j-1){
                j += 1;
                e_move = !e_move;
                up = !up;
                result[d] = mat[i][j];
                continue;
            }
            // 下移
            if((j == 0 || j == max_j-1) && e_move && i != max_i-1){
                i += 1;
                e_move = !e_move;
                up = !up;
                result[d] = mat[i][j];
                continue;
            }
            // 上斜
            if(!e_move && up){
                j += 1;
                i -= 1;
                if(i == 0 || j == max_j - 1){
                    e_move = true;
                }
                result[d] = mat[i][j];
                continue;
            }
            // 下斜
            if(!e_move && !up){
                j -= 1;
                i += 1;
                if(j == 0 || i == max_i - 1){
                    e_move = true;
                }
                result[d] = mat[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}};
        findDiagonalOrder(mat);
    }
}
