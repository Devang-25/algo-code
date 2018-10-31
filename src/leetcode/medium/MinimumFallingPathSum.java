package leetcode.medium;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] a) {
        int [][] dp = new int [a.length][a[0].length] ;
        for(int j=0;j<a[0].length;j++){
            dp[0][j] = a[0][j];
        }

        for(int i = 1;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                int min = Integer.MAX_VALUE;
                for(int k = -1; k<= 1;k++){
                    int jj = j + k;
                    if( jj >=0 && jj <= a.length-1){
                        min = Math.min(min, a[i][j]+dp[i-1][jj]);
                    }
                }
                dp[i][j] = min;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<a[0].length;i++){
            min = Math.min(min,dp[a.length-1][i]);
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum ms = new MinimumFallingPathSum();
        System.out.println(ms.minFallingPathSum( new int[][]{
                {-19,57},
                {-40,-5},
        }));
        System.out.println(ms.minFallingPathSum( new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
    }
}
