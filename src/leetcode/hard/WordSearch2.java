/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author sekha
 */
public class WordSearch2 {
    private static final int[][] MOVES = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        for(String word : uniqueWords){
            if(exist(board,word)){
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean exist(char[][] board, String  word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (existUtil(board, i, j, 0, sb, visited)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean existUtil(char[][] board, int x, int y, int pos, StringBuilder sb, boolean[][] visited) {

        if (pos == sb.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (!visited[x][y] && sb.charAt(pos) == board[x][y]) {
            visited[x][y] = true;
            for (int[] move : MOVES) {
                if (existUtil(board, x + move[0], y + move[1], pos + 1, sb, visited)) {
                    return true;
                }
            }
            visited[x][y]=false;
            
        }

        return false;
    }
    public static void main(String[] args) {
        WordSearch2 ws = new WordSearch2();
        char[][] board = {{'A'}};
        String [] words = {"A","A"};
        ws.findWords(board,words).stream().forEach(System.out::println);
    }
}
