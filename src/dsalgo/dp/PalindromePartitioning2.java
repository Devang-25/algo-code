package dsalgo.dp;

import java.util.Arrays;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        int n = s.length();
        int [] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        boolean [][] isPalin = new boolean[n][n];
        fill(isPalin,s);

        for(int i=0;i<n;i++){
            if(isPalin[0][i]){
                dp[i] = 0;
            }else{
                for(int j=i;j>0;j--){
                    if(isPalin[j][i]){
                        dp[i] = Math.min(dp[i],1+dp[j-1]);
                    }
                }
            }
        }
        return dp[n-1];
    }

    private void fill(boolean [][] isPalin, String s){
        int n = s.length();
        for(int len=0;len<n;len++){
            for(int i=0;i<n-len;i++){
                int j = i+len;
                if(i==j){
                    isPalin[i][j] = true;
                }else if(s.charAt(i) == s.charAt(j)){
                    if(j == i+1){
                        isPalin[i][j] = true;
                    }else{
                        isPalin[i][j] = isPalin[i+1][j-1];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning2 pp = new PalindromePartitioning2();
        System.out.println(pp.minCut("aabaa"));
        System.out.println(pp.minCut("aaaabbbaabaababbbabbabbabababaaaaababababaaababbabbababababbabbbabbbbba"));
    }
}
