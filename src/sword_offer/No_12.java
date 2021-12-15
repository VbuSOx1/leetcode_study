package sword_offer;

/**
 * @author weib
 * @date 2021-12-15 10:46
 * 12 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 */
public class No_12 {
    public boolean exist(char[][] board, String word) {
        int[][] visit = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (exist(board, word, i, j, visit)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word, int x, int y, int[][] visit) {
        // 不符合条件
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || word.charAt(0) != board[x][y] || visit[x][y] == 1){
            return false;
        }
        // 相等且 word为最后一个字符
        if (word.length() == 1){
            return true;
        }
        // 设置为已访问状态
        visit[x][y] = 1;
        // 下一步
        String sub = word.substring(1);
        if (exist(board, sub, x-1 ,y ,visit) ||exist(board, sub, x+1 ,y ,visit) || exist(board, sub, x ,y-1 ,visit) || exist(board, sub, x ,y+1 ,visit) ){
            return true;
        }
        // 清空访问状态
        visit[x][y] = 0;
        return false;
    }
}
