/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class MinClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        
        int [] dp = new int [cost.length+1];
        Arrays.fill(dp,0);
        for(int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        
        return dp[cost.length];
        
    }
    
    public static void main(String [] args){
        MinClimbingStairs m = new MinClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int [] {10,15,20}));
    }
    
}
