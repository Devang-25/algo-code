/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class ReverseVowels {

    private static class Solution {

        private void swapChars(StringBuffer sb, int a, int b) {
            char temp = sb.charAt(a);
            sb.setCharAt(a, sb.charAt(b));
            sb.setCharAt(b, temp);

        }

        private boolean isVowel(char a) {
            switch (a) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    return true;
                default:
                    return false;
            }
        }

        public String reverseVowels(String s) {
            StringBuffer sb = new StringBuffer(s);
            int startIndex = 0;
            int endIndex = s.length() - 1;
            while (startIndex < endIndex) {

                while (!isVowel(sb.charAt(startIndex))) {
                    startIndex++;
                }

                while (!isVowel(sb.charAt(endIndex))) {
                    endIndex--;
                }

                if (startIndex < endIndex && endIndex >= 0) {
                    swapChars(sb, startIndex++, endIndex--);
                }

            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("hello"));
    }
}
