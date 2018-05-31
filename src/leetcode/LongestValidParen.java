package leetcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mns
 */
public class LongestValidParen {

    static class Solution {

        public int longestValidParentheses(String s) {
            if (s == null || s.isEmpty() || s.length() == 0) {
                return 0;
            }

            int length = 0;
            StringBuffer sb = new StringBuffer(s);
            int index = sb.indexOf("()");
            while (sb.length() > 0 && index != -1) {
                sb.deleteCharAt(index);
                sb.deleteCharAt(index);
                index = sb.indexOf("()");
                length += 2;
            }

            return length;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("()(())"));
    }
}
