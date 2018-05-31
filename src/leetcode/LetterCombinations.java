/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sekha
 */
public class LetterCombinations {

    public static HashMap<Integer, String> MAP = null;

    static {
        MAP = new HashMap<>();
        MAP.put(2, "abc");
        MAP.put(3, "def");
        MAP.put(4, "ghi");
        MAP.put(5, "jkl");
        MAP.put(6, "mno");
        MAP.put(7, "pqrs");
        MAP.put(8, "tuv");
        MAP.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if(digits.length() > 0){    
            letterCombinationsUtil(digits, 0, "", result);
        }
        return result;
    }

    public void letterCombinationsUtil(String digits, int currentIndex, String acc, List<String> result) {

        if (currentIndex == digits.length()) {
            result.add(acc);
            return;
        }

        int num = Integer.parseInt("" + digits.charAt(currentIndex));
        String value = MAP.get(num);
        for (int i = 0; i < value.length(); i++) {
            letterCombinationsUtil(digits, currentIndex + 1, acc + value.charAt(i), result);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        List<String> result = lc.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
