package stack_and_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weib
 * @date 2021-06-22 11:02
 * https://leetcode-cn.com/problems/flood-fill/
 * <p>
 * 图像渲染
 */
public class No733_Flood_Fill {


    // 广度优先搜索
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int oldColor = image[sr][sc];
//        Queue<Coordinate> queue = new LinkedList<>();
//        Coordinate coordinate = new Coordinate(sr, sc);
//        while(coordinate != null || queue != null){
//            if(image[coordinate.r][coordinate.c] == oldColor){
//                image[coordinate.r][coordinate.c] = newColor;
//
//            }
//        }
//        return null;
//    }
    // 深度优先搜索
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        fill(image, sr, sc, newColor, oldColor);
        return image;
    }


    public static void fill(int[][] image, int r, int c, int newColor, int oldColor) {
        if (r >= image.length || r < 0) {
            return;
        }
        if (c >= image[0].length || c < 0) {
            return;
        }
        if (image[r][c] == oldColor) {
            image[r][c] = newColor;
            // 上
            fill(image, r - 1, c, newColor, oldColor);
            // 下
            fill(image, r + 1, c, newColor, oldColor);
            // 左
            fill(image, r, c - 1, newColor, oldColor);
            // 右
            fill(image, r, c + 1, newColor, oldColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        floodFill(image, 1, 1, 1);
    }
}
