package leetcode.medium;

/**
 * Created by mns on 11/2/18.
 */
public class GameOfLife {
    private static final int [][] DIR = {{0,1},{0,-1},{-1,0},{-1,1},{-1,-1}, {1,0},{1,1},{1,-1}};

    // -1 => dead but become alive because of 3 alive neighbors
    // 2 => alive but dies to under population (<2 live neighbors
    // 3 => alive and remains alive because of 2/3 live neighbors
    // 2 =? alive but dies due to overpopulation >3 live neighbors
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }

        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveN = getLiveNeighbors(i,j,board);
                if( board[i][j] == 0 && liveN == 3){
                    board[i][j] = -1;
                }else if(board[i][j] == 1){
                    if(liveN < 2 || liveN > 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -1 || board[i][j] == 1){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }

    }

    int getLiveNeighbors (int x, int y, int [][] board){
        int live = 0;
        for(int [] dir : DIR){
            int x1 = x+dir[0];
            int y1 = y+dir[1];

            if(x1 >= 0 && x1 < board.length && y1 >=0 && y1 < board[0].length){
                if(board[x1][y1] >= 1){
                    live++;
                }
            }
        }
        return live;
    }

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        int [] [] state = new int [][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        g.gameOfLife(state);
        for(int i=0;i<state.length;i++){
            for(int j=0;j<state[0].length;j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }
}
