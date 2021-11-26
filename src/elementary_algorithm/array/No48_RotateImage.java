package elementary_algorithm.array;

/**
 * @author weib
 * @date 2021-03-24 20:54
 * https://leetcode-cn.com/problems/rotate-image/
 * 旋转图像
 * 找规律
 * 旋转之后所有的 行 是之前矩阵的 列
 * 所有的 列 是之前矩阵 n-1-行
 * 然后在逐行 逐列去旋转 （四次交换为一轮）
 */
public class No48_RotateImage {
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

    public static void printMatrix(int[][] matrix){
        for(int[] ms : matrix){
            for (int m : ms){
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);


    }
}
