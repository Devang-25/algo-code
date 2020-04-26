package leetcode.easy;

import java.util.HashMap;

public class ProjectionArea3D {
    public int projectionArea(int[][] grid) {
        int totalArea = 0;

        HashMap<Integer,Integer> y = new HashMap<>();
        HashMap<Integer,Integer> z = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j] > 0){
                    totalArea++;
                }
                y.put(i, Math.max(grid[i][j],y.getOrDefault(i,grid[i][j])));
                z.put(j, Math.max(grid[i][j],z.getOrDefault(j,grid[i][j])));
            }
        }

        for(Integer i : y.keySet()){
            totalArea += y.get(i);
        }
        for(Integer i : z.keySet()){
            totalArea += z.get(i);
        }

        return totalArea;
    }

    public static void main(String[] args) {
        ProjectionArea3D p = new ProjectionArea3D();
        System.out.println(p.projectionArea(new int[][]{{1,0},{0,2}}));
    }
}
