package leetcode.medium;

public class TicTacToe {
    int [] rows, cols;
    int diag1, diag2;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];;
    }

    public int move(int row, int col, int player) {
        int val = player == 1? 1:-1;
        int n = rows.length;
        rows[row] += val;
        cols[col] += val;

        if(row == col){
            diag1 += val;
        }
        if( row + col == n-1){
            diag2 += val;
        }

        if(rows[row] == n || cols[col] == n || diag1 == n || diag2 == n){
            return 1;
        }else if(rows[row] == -n || cols[col] == -n || diag1 == -n || diag2 == -n){
            return 2;
        }
        return 0;
    }
}
