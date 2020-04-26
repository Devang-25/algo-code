package leetcode.easy;

/**
 * Created by mns on 6/26/18.
 */
public class MaxAreaOfIsland {
    int [][] neightbors = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    max = Math.max(util(grid,i,j),max);
                }
            }
        }
        return max;
    }

    int util(int [][] grid, int i, int j){
        if( i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0 ){
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;
        for(int index=0;index<neightbors.length;index++){
            area += util(grid,i+neightbors[index][0], j+ neightbors[index][1]);
        }

        return area;

    }

    public static void main(String[] args) {
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        System.out.println(ma.maxAreaOfIsland(new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1},
        }));
    }
}
