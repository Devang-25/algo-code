package medium;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by mns on 12/28/18.
 */
public class TheMaze {
    private static final int [][] DIR = {{0,1},{1,0}, {-1,0}, {0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }

        boolean [] visited = new boolean[maze.length * maze[0].length];
        LinkedList<int []> q = new LinkedList<>();
        q.add(start);
        visited[start[0]*maze[0].length+start[1]] = true;

        while(!q.isEmpty()){
            int [] front = q.poll();

            for(int [] dir : DIR){
                int x = front[0];
                int y = front[1];
                while( isValid(x+dir[0],y+dir[1],maze)){
                    x += dir[0];
                    y += dir[1];
                }

                if(x == destination[0] && y == destination[1]){
                    return true;
                }

                if(!visited[x*maze[0].length+y]){
                    visited[x*maze[0].length+y] = true;
                    q.add(new int[]{x,y});
                }

            }

        }

        return false;
    }

    private boolean isValid(int x, int y, int [][] m){
        return (x >=0 && x < m.length && y >=0 && y < m[0].length && m[x][y] !=1);
    }

    //much slower due to serialization
    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }

        HashSet<String> visited = new HashSet<>();
        LinkedList<int []> q = new LinkedList<>();
        q.add(start);
        visited.add(start[0]+ "," + start[1]);

        while(!q.isEmpty()){
            int [] front = q.poll();

            for(int [] dir : DIR){
                int x = front[0];
                int y = front[1];
                while( isValid(x+dir[0],y+dir[1],maze)){
                    x += dir[0];
                    y += dir[1];
                }

                if(x == destination[0] && y == destination[1]){
                    return true;
                }

                if(!visited.contains(x+","+y)){
                    visited.add(x+","+y);
                    q.add(new int[]{x,y});
                }

            }

        }

        return false;
    }

    public static void main(String[] args) {
        TheMaze m = new TheMaze();
        System.out.println(m.hasPath(
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
