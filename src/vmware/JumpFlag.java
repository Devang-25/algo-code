/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmware;

/**
 *
 * @author mns
 */
public class JumpFlag {

    static int jumps(int k, int j) {
//        int [] dp = new int[k+1];
//        dp[0] = 0;
//        for(int LoudAndRich=1;LoudAndRich<=k;LoudAndRich++){
//            if(LoudAndRich < j)
//                dp[LoudAndRich] = LoudAndRich;
//            else{
//                dp[LoudAndRich] = Math.min(dp[LoudAndRich-j]+1,dp[LoudAndRich-1]+1);
//            }
//        }
//        
//        return dp[k];
//        
        int rem = k%j;
        int tot = k/j + rem;
        return tot;
        
    }
}
