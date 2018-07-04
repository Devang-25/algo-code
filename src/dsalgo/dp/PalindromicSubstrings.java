package dsalgo.dp;

import java.util.Arrays;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        boolean [][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],true);
        }
        int count = 0;
        for(int size=1;size<=s.length();size++){
            for(int i=0;i<s.length()-size+1;i++){
                int j = i+size-1;
                if(i == j){
                    dp[i][j] = true;
                    count++;
                }else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j]){
                      count++;
                    }
                }else{
                    dp[i][j] = false;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("aaa"));
    }
}
