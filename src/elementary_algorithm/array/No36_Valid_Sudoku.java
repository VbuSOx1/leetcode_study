package elementary_algorithm.array;

/**
 * @author weib
 * @date 2020-12-18 9:43
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * 这题不会
 */
public class No36_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] subBox = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '1';
                int subBoxIndex = (i/3)*3 + j/3;
                if(rows[i][num] == 1 || cols[j][num] == 1 || subBox[subBoxIndex][num] == 1){
                    return false;
                }
                rows[i][num] = 1;
                cols[j][num] = 1;
                subBox[subBoxIndex][num] = 1;
            }
        }
        return true;
    }
}
