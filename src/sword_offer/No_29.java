package sword_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weib
 * @date 2021-12-29 10:40
 *  29. 顺时针打印矩阵
 *  https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class No_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int c = 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int[] result = new int[matrix.length*matrix[0].length];
        while (index < result.length) {
            // 右
            while (index < result.length && j <= matrix[0].length - c - 1) {result[index++] = matrix[i][j++];}
            j -= 1;
            i += 1;
            // 下
            while (index < result.length && i <= matrix.length - c - 1) {result[index++] = matrix[i++][j];}
            i -= 1;
            j -= 1;
            // 左
            while (index < result.length && j >= c) {result[index++] = matrix[i][j--];}
            i -= 1;
            j += 1;
            // 上
            while (index < result.length && i > c) {result[index++] = matrix[i--][j];}
            c++;
            i = c;
            j = c;
        }
        return result;

    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList();
        }
        int c = 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int[] result = new int[matrix.length*matrix[0].length];
        while (index < result.length) {
            // 右
            while (index < result.length && j <= matrix[0].length - c - 1) {result[index++] = matrix[i][j++];}
            j -= 1;
            i += 1;
            // 下
            while (index < result.length && i <= matrix.length - c - 1) {result[index++] = matrix[i++][j];}
            i -= 1;
            j -= 1;
            // 左
            while (index < result.length && j >= c) {result[index++] = matrix[i][j--];}
            i -= 1;
            j += 1;
            // 上
            while (index < result.length && i > c) {result[index++] = matrix[i--][j];}
            c++;
            i = c;
            j = c;
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }


    @Test
    public void test(){
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder2(a));
    }
}
