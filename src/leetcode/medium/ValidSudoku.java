package medium;

import java.util.HashSet;

/**
 * Created by mns on 7/22/18.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> row = new HashSet<>();
        HashSet<String> col = new HashSet<>();
        HashSet<String> box = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(i + " " + board[i][j])
                            || col.contains(j + " " + board[i][j])
                            || box.contains((i / 3) * 3 + j / 3 + " " + board[i][j])) {
                        return false;
                    }
                    row.add(i + " " + board[i][j]);
                    col.add(j + " " + board[i][j]);
                    box.add((i / 3) * 3 + j / 3 + " " + board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

        }));
    }
}
