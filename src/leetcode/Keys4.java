/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class Keys4 {
    public int maxA(int N) {
        int [] dp = new int[N+1];
        
        for(int i=0;i<=N;i++){
            dp[i] = i;
        }
        
        for(int i=0;i<=N;i++){
            for(int j= i-3; j>=0;j--){
                int temp = dp[i];
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
                //if no longer increasing, then breank (improves from O(n^2) to o(n)
                if(temp > dp[j]*(i-j-1)){
                    break;
                }
            }
        }
        
        return dp[N];
    }
    
    public static void main(String[] args) {
        Keys4 k = new Keys4();
        System.out.println(k.maxA(0));
        System.out.println(k.maxA(1));
        System.out.println(k.maxA(2));
        System.out.println(k.maxA(3));
        System.out.println(k.maxA(4));
        System.out.println(k.maxA(5));
        System.out.println(k.maxA(6));
        System.out.println(k.maxA(7));
        System.out.println(k.maxA(8));
        System.out.println(k.maxA(9));
    }
}
