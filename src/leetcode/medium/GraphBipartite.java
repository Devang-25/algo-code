package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0){
            return false;
        }
        int [] visited = new int [graph.length];
        Arrays.fill(visited,-1);

        for(int i=0;i<graph.length;i++){
            if(visited[i] == -1) {
                visited[i] = 0;
            }
            LinkedList<Integer> q = new LinkedList<>();
            q.push(i);
            while(!q.isEmpty()){
                int top = q.poll();
                for(int j = 0;j<graph[top].length;j++){
                    if(visited[graph[top][j]] == visited[top]){
                        return false;
                    }
                    if(visited[graph[top][j]] == -1){
                        q.add(graph[top][j]);
                    }
                    visited[graph[top][j]] = visited[top] == 0?1:0;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        GraphBipartite gb = new GraphBipartite();
        System.out.println(gb.isBipartite(new int[][]{
                {1,3},
                {0,2},
                {1,3},
                {0,2},
        }));
    }
}
