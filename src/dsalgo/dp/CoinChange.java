package dsalgo.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int [] coins, int amount){
        if(coins == null){
            return 0;
        }
        int [] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                if(j-coins[i] >= 0 && dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i]]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
//        System.out.println(cc.coinChange(new int[]{1,2,5},11));
//        System.out.println(cc.coinChange(new int[]{2},3));
        System.out.println(cc.coinChange(new int[]{2,5,10,1},27));
    }
}
