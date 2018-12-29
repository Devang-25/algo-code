package leetcode.medium;

public class LongestLineOfConsecutive1 {
    public int longestLine2(int[][] m) {
        if(m == null || m.length == 0){
            return 0;
        }
        int [][][] dp = new int[m.length][m[0].length][4];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j] == 1){
                    dp[i][j][0] = 1 + get2(dp,i,j-1,0);
                    dp[i][j][1] = 1 + get2(dp,i-1,j,1);
                    dp[i][j][2] = 1 + get2(dp,i-1,j-1,2);
                    dp[i][j][3] = 1 + get2(dp,i-1,j+1,3);

                    for(int k=0;k<4;k++){
                        max = Math.max(max, dp[i][j][k]);
                    }
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0:max;
    }

    public int longestLine(int[][] m) {
        if(m == null || m.length == 0){
            return 0;
        }
        int [][] dp = new int[m[0].length][4];
        int [] prevDiag = new int [m[0].length];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(m[i][j] == 1){
                    dp[j][0] = 1 + get(dp,j-1,0);
                    dp[j][1] = 1 + get(dp,j,1);
                    dp[j][2] = 1 + (j>0? prevDiag[j-1]:0);
                    dp[j][3] = 1 + get(dp,j+1,3);

                    for(int k=0;k<4;k++){
                        max = Math.max(max, dp[j][k]);
                    }
                }else{
                    for(int k=0;k<4;k++){
                       dp[j][k] = 0;
                    }
                }
            }
            for(int j=0;j<m[0].length;j++){
                prevDiag[j] = dp[j][2];
            }
        }

        return max == Integer.MIN_VALUE ? 0:max;
    }

    private int get2(int [][][] dp, int i, int j, int k ){
        if(i >= 0 && i <dp.length && j >=0 && j < dp[0].length && k >=0 && k < dp[0][0].length){
            return dp[i][j][k];
        }

        return 0;
    }
    private int get(int [][] dp, int j, int k ){
        if(j >= 0 && j <dp.length && k >=0 && k < dp[0].length){
            return dp[j][k];
        }

        return 0;
    }

    public static void main(String[] args) {
        LongestLineOfConsecutive1 l = new LongestLineOfConsecutive1();
        System.out.println(l.longestLine(new int[][] {
                {0, 1, 1, 0},
                {0, 1 ,1 ,0},
                {0, 0 ,0 ,1},
        }));
        System.out.println(l.longestLine(new int[][] {
                {1, 1, 1, 1},
                {0, 1 ,1 ,0},
                {0, 0 ,0 ,1},
        }));
    }
}
