package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static final int DIR[][] = new int [][]{{1,-1},{-1,1},{-1,-1}};
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solveNQueensUtil(result, board,0);
        return result;
    }

    public void solveNQueensUtil(List<List<String>> result, char [][] board, int j){
        if(j == board.length){
            constructList(result, board);
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isValid(board,i,j)){
                board[i][j] = 'Q';
                solveNQueensUtil(result,board,j+1);
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


    private void constructList(List<List<String>> result, char [][] board){
        List<String> ls = new ArrayList<>();
        StringBuilder row = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               row.append(board[i][j]);
            }
            ls.add(row.toString());
            row.setLength(0);
        }
        result.add(ls);
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<String>> out = nq.solveNQueens(4);
        for(List<String> str : out){
            for(String s : str){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
