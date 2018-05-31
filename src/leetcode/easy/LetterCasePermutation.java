/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sekha
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        letterCasePermutationUtil(S.toCharArray(), 0, result);
        return result;
    }

    private void letterCasePermutationUtil(char[] s, int pos, List<String> result) {
        
        result.add(new String(s));
        for (int j = pos; j < s.length; j++) {
            char ch = s[j];
            if (Character.isAlphabetic(ch)) {
                s[j] = flip(ch);
                letterCasePermutationUtil(s, j+1, result);
                s[j]= ch;
            }
        }

    }
    
    private char flip(char ch){
        return Character.isUpperCase(ch)? Character.toLowerCase(ch):Character.toUpperCase(ch);
    }

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        lcp.letterCasePermutation("a1b2").stream().forEach(System.out::println);
        lcp.letterCasePermutation("3z4").stream().forEach(System.out::println);
        lcp.letterCasePermutation("12345").stream().forEach(System.out::println);
        lcp.letterCasePermutation("").stream().forEach(System.out::println);
    }
}
