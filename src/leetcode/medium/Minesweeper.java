package leetcode.medium;

import java.util.ArrayList;

public class Minesweeper {

    private static final int [][] N = {
            {0,1},{1,0},{-1,-1},{1,1},{1,-1},{-1,1},{0,-1},{-1,0}
    };
    private class Result {
        ArrayList<int [] > neighbors = new ArrayList<>();
        int mines = 0;
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        updateBoardUtil(board,click);
        return board;
    }

    private void updateBoardUtil(char [][] board, int[] click){
        int x = click[0], y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return;
        }

        if(board[x][y] == 'B'){
            return;
        }

       Result r = getNeighborDetails(board,click[0],click[1]);
        if(r.mines == 0){
            board[x][y] = 'B';
            for(int [] neighbor : r.neighbors){
                updateBoardUtil(board,neighbor);
            }
        }else{
            board[x][y] = (char)('0' + r.mines);
        }

    }

    private Result getNeighborDetails(char [][] board, int x, int y){
        Result r = new Result();
        for(int i=0;i<N.length;i++){
            int a = x+N[i][0], b = y+N[i][1];
            if(a < board.length && a >= 0
                    && b < board[0].length && b >= 0){
                if(board[a][b] == 'M'){
                    r.mines++;
                }else if(board[a][b] == 'E'){
                    r.neighbors.add(new int[]{a,b});
                }
            }
        }
        return r;
    }

    private void updateBoardUtil2(char [][] board, int[] click){
        int x = click[0], y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return;
        }

        if(board[x][y] == 'B'){
            return;
        }

        int numMinesAround = getNumMinesAround(board, click[0], click[1]);
        if(numMinesAround == 0){
            ArrayList<int []> emptyNeighbors = getEmptyNeighbors(board, click[0], click[1]);
            board[x][y] = 'B';
            for(int [] neighbor : emptyNeighbors){
                updateBoardUtil2(board,neighbor);
            }
        }else{
            board[x][y] = (char)('0' + numMinesAround);
        }

    }

    private int getNumMinesAround (char [][] board, int x, int y){
        int numMines = 0;
        for(int i=0;i<N.length;i++){
            int a = x+N[i][0], b = y+N[i][1];
            if(a < board.length && a >= 0
                    && b < board[0].length && b >= 0){
                if(board[a][b] == 'M'){
                    numMines++;
                }
            }
        }
        return numMines;
    }

    private ArrayList<int[]> getEmptyNeighbors(char [][] board, int x, int y){
        ArrayList<int []> result=  new ArrayList<>();
        for(int i=0;i<N.length;i++){
            int a = x+N[i][0], b = y+N[i][1];
            if(a < board.length && a >= 0
                    && b < board[0].length && b >= 0){
                if(board[a][b] == 'E'){
                    result.add(new int[]{a,b});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Minesweeper ms = new Minesweeper();
        char [][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        ms.updateBoard(board,new int[]{3,0});
        System.out.println();
    }
}
