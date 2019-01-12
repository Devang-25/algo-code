package leetcode.hard;

public class LongestIncreasingPathMatrix {
    private static final int [][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 1;
        int [][] mem = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(dfs(matrix,mem,i,j), max);
            }
        }

        return max;
    }

    int dfs(int [][] matrix, int [][] mem ,int i, int j){
        if(mem[i][j] != 0){
            return mem[i][j];
        }
        int max = 1;
        for(int [] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];

            if(isValid(x,y,matrix.length, matrix[0].length) && matrix[i][j] > matrix[x][y]){
                max = Math.max(max, 1+dfs(matrix, mem,x,y));
            }
        }

        mem[i][j] = max;
        return mem[i][j];
    }

    private boolean isValid(int x, int y , int m, int n){
        return x >=0 && x < m && y >=0 && y< n;
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix l = new LongestIncreasingPathMatrix();
        System.out.println(l.longestIncreasingPath(new int[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        }));
        System.out.println(l.longestIncreasingPath(new int[][]{
                {3,4,5},
                {3,2,6},
                {2,2,1}
        }));
    }
}
