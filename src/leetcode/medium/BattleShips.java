package medium;

/**
 * Created by mns on 8/22/18.
 */
public class BattleShips {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;

        int cnt=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.' || (i >0 && board[i-1][j] =='X') || (j >0 && board[i-1][j] == 'X')) continue;
                cnt++;

            }
        }

        return cnt;
    }
}
