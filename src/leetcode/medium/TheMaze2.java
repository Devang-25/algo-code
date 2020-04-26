package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by mns on 12/28/18.
 */
public class TheMaze2 {
    private static final int [][] DIR = {{0,1},{1,0}, {-1,0}, {0,-1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return -1;
        }

        int m = maze.length, n = maze[0].length;
        int [] minDistance = new int[m*n];
        Arrays.fill(minDistance,Integer.MAX_VALUE);
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.add(new int[]{start[0],start[1],0});

        while(!q.isEmpty()){
            int [] front = q.poll();

            for(int [] dir : DIR){
                int x = front[0];
                int y = front[1];
                int dist = 0;
                while( isValid(x+dir[0],y+dir[1],maze)){
                    x += dir[0];
                    y += dir[1];
                    dist++;
                }

                if(minDistance[x*n+y] <= front[2]+dist){
                    continue;
                }else{
                    minDistance[x*n+y] = front[2]+dist;
                    q.add(new int[]{x,y,minDistance[x*n+y]});
                }
            }

        }

        return minDistance[destination[0]*n +destination[1]] == Integer.MAX_VALUE? -1 :
                minDistance[destination[0]*n+destination[1]];
    }

    private boolean isValid(int x, int y, int [][] m){
        return (x >=0 && x < m.length && y >=0 && y < m[0].length && m[x][y] !=1);
    }

    public static void main(String[] args) {
        TheMaze2 t = new TheMaze2();
        System.out.println(t.shortestDistance(
                new int[][]{
                        {0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}
                }, new int[]{0,4}, new int[]{4,4}
        ));
    }
}
