package dsalgo.dp;

import java.util.Arrays;

public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        int maxSize = 1, begin = 0, end = 0;
        boolean [][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],true);
        }
        for(int size=1;size<=s.length();size++){
            for(int i=0;i<s.length()-size+1;i++){
                int j = i+size-1;
                if(i == j){
                    dp[i][j] = true;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j] && size > maxSize){
                        maxSize = size;
                        begin = i;end = j;
                    }
                }else{
                    dp[i][j] = false;
                }

            }
        }

        return s.substring(begin,end+1);
    }

    public static void main(String[] args) {
        LongestPalidromicSubstring lps = new LongestPalidromicSubstring();
        System.out.println(lps.longestPalindrome("cbbd"));
        System.out.println(lps.longestPalindrome("babad"));
        System.out.println(lps.longestPalindrome("bb"));
    }
}
