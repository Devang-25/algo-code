package dsalgo.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        if(n <= 0){
            return 0;
        }

        ArrayList<Integer> perfSq = new ArrayList<>();
        int x = 1;
        while(x*x <= n){
            perfSq.add(x*x++);
        }


        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<perfSq.size();i++){
            for(int j=1;j<n+1;j++){
                if(j-perfSq.get(i) >=0 && dp[j-perfSq.get(i)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - perfSq.get(i)]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
//        System.out.println(ps.numSquares(12));
//        System.out.println(ps.numSquares(13));
        System.out.println(ps.numSquares(1));
    }
}
