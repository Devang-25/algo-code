package dp;

/**
 * Created by mns on 8/1/18.
 */
public class MaximumProductCutting {

    public long maxProdCutting(int n){
        return maxProdCuttingUtil(n);
    }
    public long maxProdCuttingUtil(int n){
        if(n == 0 || n==1){
            return n;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        long max = Long.MIN_VALUE;
        for(int i=1;i<n;i++){
            max = Math.max(max, Math.max(i*(n-i),i*( maxProdCuttingUtil(n-i) )));
        }

        return max;
    }

    public long maxProdCuttingDP(int n){
        int [] dp = new int [n+1];
        dp[0] =0; dp[1] = 1; dp[2] = 1; dp[3] = 2;

        for(int i=4;i<n+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<i;j++){
                max = Math.max(dp[i-j]*dp[j],Math.max((i-j)*j,max));
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        MaximumProductCutting mpc = new MaximumProductCutting();
        System.out.println(mpc.maxProdCuttingDP(10));
    }

}
