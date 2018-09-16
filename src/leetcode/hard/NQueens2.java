package leetcode.hard;

import java.util.Arrays;

public class NQueens2 {
    int cnt = 0;
    public static final int DIR[][] = new int [][]{{1,-1},{-1,1},{-1,-1}};
    public int totalNQueens(int n) {
        cnt = 0;
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solveNQueensUtil(board,0);
        return cnt;
    }

    public void solveNQueensUtil(char [][] board, int j){
        if(j == board.length){
            cnt++;
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isValid(board,i,j)){
                board[i][j] = 'Q';
                solveNQueensUtil(board,j+1);
                board[i][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y){
        int d = board.length;
        for(int i=0;i<board.length;i++){
            if(board[i][y] == 'Q'){
                return false;
            }
            if(board[x][i] == 'Q'){
                return false;
            }
            for(int j = 0;j<DIR.length;j++){
                int a = x+DIR[j][0]*i, b = y+DIR[j][1]*i;
                if(a >=0 && a < d && b >=0 && b < d && board[a][b] == 'Q'){
                    return false;
                }
            }
        }

        return true;
    }
}
