package leetcode.hard;

import java.util.Arrays;

public class DistinctSubsequences2 {
    public int distinctSubseqII(String s) {
        int[] last = new int[26];
        int MOD = 1000000000 + 7;
        Arrays.fill(last, -1);
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<=n; i++)
        {
            dp[i] = 2*(dp[i-1]%MOD)%MOD;
            if (last[(int)s.charAt(i-1)-'a'] != -1)
                dp[i] = (dp[i] - dp[last[(int)s.charAt(i-1)-'a']])%MOD;

            last[(int)s.charAt(i-1)-'a'] = (i-1);
        }

        return dp[n]-1;
    }

    public static void main(String[] args) {
        DistinctSubsequences2 ds = new DistinctSubsequences2();
        System.out.println(ds.distinctSubseqII("adbae"));
    }
}
