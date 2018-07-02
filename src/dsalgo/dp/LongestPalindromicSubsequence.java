package dsalgo.dp;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int [][] dp = new int[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            for(int start=0;start<s.length()-i;start++){
                int end = start+i;
                if(start == end){
                    dp[start][end] = 1;
                }else if(s.charAt(start) == s.charAt(end)){
                    dp[start][end] = 2 + dp[start+1][end-1];
                }else{
                    dp[start][end] = Math.max(dp[start+1][end],dp[start][end-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
        System.out.println(l.longestPalindromeSubseq("cbbd"));
        System.out.println(l.longestPalindromeSubseq("bbbab"));
    }

}
