package dsalgo.dp;

public class MinimumAsciiDelete {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp = new int[s1.length()+1][s2.length()+1];

        dp[0][0] = 0;
        for(int i=1;i<s1.length()+1;i++){
            dp[i][0] = dp[i-1][0]+s1.charAt(i-1);
        }
        for(int i=1;i<s2.length()+1;i++){
            dp[0][i] = dp[0][i-1]+s2.charAt(i-1);
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j], s2.charAt(j-1) + dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];

    }

    public static void main(String[] args) {
        MinimumAsciiDelete mad = new MinimumAsciiDelete();
        System.out.println(mad.minimumDeleteSum("delete","leet"));
        System.out.println(mad.minimumDeleteSum("sea","eat"));
    }
}
