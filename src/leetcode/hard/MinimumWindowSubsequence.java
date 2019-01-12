package leetcode.hard;

import java.util.Arrays;

public class MinimumWindowSubsequence {

    private int minLength;
    private String minLengthWord;
    public String minWindow(String S, String T) {
         if(S == null || T == null || S.length() == 0 || T.length() == 0){
             return "";
         }

         minLength = S.length()+1;
         minLengthWord = "";
         int [][] cache = new int[S.length()+1][T.length()+1];
         for(int i=0;i<cache.length;i++){
             Arrays.fill(cache[i],-1);
         }
         util(S,T,0,0,cache);
         //print(cache);

         return minLengthWord;
    }

    private int util(String s, String t, int i, int j, int[][] cache){

        if(cache[i][j] != -1){
            return cache[i][j];
        }
        if( j == t.length()){
            return i;
        }
        if(i == s.length()){
            return Integer.MAX_VALUE;
        }

        int result;
        if(s.charAt(i) == t.charAt(j)){
            int x = util(s,t,i+1,j+1, cache);
            int y = util(s,t,i+1,j,cache);
            result = (x <=y)? x :y;
            if(j == 0){
                if(minLength >= result - i){
                    minLength = result-i;
                    minLengthWord = s.substring(i,result);
                }
            }
        }else{
            result = util(s,t,i+1,j,cache);
        }

        return (cache[i][j] = result);
    }

    private void print( int [][] cache){
        for(int i=0;i<cache.length;i++){
            for(int j=0; j<cache[0].length;j++){
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String minWindow2(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        print(dp);
        int start = 0, len = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
                }
            }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence ms = new MinimumWindowSubsequence();
        System.out.println(ms.minWindow("abcdebdde","bde"));
        System.out.println(ms.minWindow("abcdede","de"));
        System.out.println(ms.minWindow("abcdede","xy"));
        System.out.println(ms.minWindow("abcdede","abcdede"));
        System.out.println(ms.minWindow("cnhczmccqouqadqtmjjzl", "cm"));
        System.out.println(ms.minWindow("wcbsuiyzacfgrqsqsnodwmxzkz","xwqe"));
        System.out.println(ms.minWindow("hpsrhgogezyfrwfrejytjkzvgpjnqil","ggj"));
    }
}
