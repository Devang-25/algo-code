/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class ReverseWordsInString {

    //In place
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] splits = s.split(" ");
        //System.out.println(splits.length);
        String result = "";
        for (int i = splits.length - 1; i >= 0; i--) {
            if (splits[i].trim().length() > 0) {
                result += splits[i].trim() + " ";
            }
        }

        return result.trim();
    }

    public static void main(String[] args) {
        ReverseWordsInString r = new ReverseWordsInString();
        System.out.println(r.reverseWords("    a   b "));
    }

}
