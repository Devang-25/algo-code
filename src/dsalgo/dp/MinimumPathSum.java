package dsalgo.dp;

public class MinimumPathSum {
    public int minPathSum(int [][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = grid[i][j] + getMin(i,j,dp);
            }
        }
        return dp[m-1][n-1];
    }
    private int getMin(int i,int j, int [][] arr){
        if(i == 0 && j ==0 ){
            return 0;
        }else{
            int m = i == 0 ? Integer.MAX_VALUE : arr[i-1][j];
            int n = j == 0 ? Integer.MAX_VALUE : arr[i][j-1];
            return Math.min(m,n);
        }
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        System.out.println(m.minPathSum(new int [][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
