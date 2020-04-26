package leetcode.medium;

import java.util.Arrays;

/**
 * Created by mns on 12/19/18.
 */
public class MostStonesRemovedFromSameRowOrColumn {
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }
        int [] visited = new int [stones.length];
        Arrays.fill(visited, -1);

        int id = 0;
        for(int i=0;i<stones.length;i++){
            if(visited[i] == -1){
                removeStonesUtil(stones,i,visited,id++);
            }
        }

        return stones.length - id;
    }

    void removeStonesUtil( int [][] stones, int index, int [] visited, int id){
        if(index >= visited.length || visited[index] != -1){
            return;
        }

        visited[index] = id;
        for(int i=0;i<stones.length;i++){
            if( visited[i] == -1 && stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1]){
                removeStonesUtil(stones, i, visited, id );
            }
        }
    }

    public static void main(String[] args) {
        MostStonesRemovedFromSameRowOrColumn m = new MostStonesRemovedFromSameRowOrColumn();
        System.out.println(m.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(m.removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
        System.out.println(m.removeStones(new int[][]{{0,0}}));
    }
}
