package Array_and_String;

/**
 * @author weib
 * @date 2021-11-07 18:32
 */
public class RotateMatrixLCCI {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //   int i = 0 ,j =0;
        // 行
        for(int i = 0; i < n/2; i++){
            // 列
            for(int j = i; j < (n-1-i); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
