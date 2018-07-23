package dsalgo.dp;

import java.util.Arrays;

public class CoinChange2 {

    public int change(int amount , int [] coins){
        int  [] dp = new int[amount+1];
        Arrays.fill(dp,0);
        dp[0] = 1;

        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if( j - coins[i-1] >= 0){
                    dp[j] += dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];

    }

    public int change2(int amount , int [] coins){
        int  [][] dp = new int[coins.length+1][amount+1];
        Arrays.fill(dp[0],0);
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                dp[i][j] = dp[i-1][j];
                if( j - coins[i-1] >= 0){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];

    }

    public static void main(String[] args) {
        CoinChange2 c = new CoinChange2();
        System.out.println(c.change(5, new int[]{1,2,5}));
    }
}
