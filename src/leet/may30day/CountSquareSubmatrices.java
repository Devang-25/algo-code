package leet.may30day;

public class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int total = matrix[0][0] == 1?-1:0;
        for(int i = 0;i<m;i++){
            if(matrix[i][0]==1){
                dp[i][0] = 1;
                total++;
            }   
        }
        
        for(int i = 0;i<n;i++){
            if(matrix[0][i]==1){
                dp[0][i] = 1;
                total++;
            }      
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    //dp[i][j] = 1 + IntStream.of(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]).min().getAsInt();
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]);
                    total += dp[i][j];
                }
            }
        }

        return total;
    }
}