package leetcode.medium;

import java.util.ArrayList;

public class SurroundedRegions {
    public void solve2(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2){
            return;
        }

        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(board[i][j] == 'O'){
                    ArrayList<int []> pos = new ArrayList<>();
                    if(!util2(board,i,j,pos)){
                        for(int [] p : pos){
                            board[p[0]][p[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
    private final int [][] dir = {{0,-1},{-1,0},{1,0},{0,1}};
    private boolean util2(char [][] board, int i, int j, ArrayList<int []> pos){

        if(i == board.length-1 || j == board[0].length-1 || i==0 || j==0){
            if(board[i][j] == 'O'){
                return true;
            }
            return false;
        }

        if(board[i][j] == 'O'){
            pos.add(new int[]{i,j});
            boolean leaks = false;
            board[i][j] = 'K';
            for(int k=0;k<dir.length;k++){
                leaks = leaks || util2(board,i+dir[k][0],j+dir[k][1],pos);
            }
            board[i][j] = 'O';
            return leaks;
        }

        return false;
    }

    public void solve(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2){
            return;
        }

        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(board[i][j] == 'O'){
                    if(!util(board,i,j)){
                        change(board,i,j);
                    }
                }
            }
        }
    }

    private void change(char [][] board, int i, int j){
        if(i == board.length-1 || j == board[0].length-1 || i==0 || j==0){
            return;
        }
        if(board[i][j] == 'O'){
            board[i][j] = 'X';
            for(int k=0;k<dir.length;k++){
                change(board,i+dir[k][0],j+dir[k][1]);
            }
        }
    }

    private boolean util(char [][] board, int i, int j){

        if(i == board.length-1 || j == board[0].length-1 || i==0 || j==0){
            if(board[i][j] == 'O'){
                return true;
            }
            return false;
        }

        if(board[i][j] == 'O'){
            boolean leaks = false;
            board[i][j] = 'K';
            for(int k=0;k<dir.length;k++){
                leaks = leaks || util(board,i+dir[k][0],j+dir[k][1]);
            }
            board[i][j] = 'O';
            return leaks;
        }

        return false;
    }
}
