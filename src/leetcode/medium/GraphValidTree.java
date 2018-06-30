package medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mns on 6/26/18.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        boolean cycle = dfs(0, visited, adjList,-1);
        if(cycle){
            return false;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n, boolean[] visited, HashMap<Integer, ArrayList<Integer>> adjList, int parent) {
        visited[n] = true;
        for(Integer neighbor : adjList.get(n)){
            if(visited[neighbor] && neighbor != parent || (!visited[neighbor] && dfs(neighbor,visited,adjList,n))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GraphValidTree gv = new GraphValidTree();
        System.out.println(gv.validTree(5,new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {1,3},
                {1,4}
        }));
        System.out.println(gv.validTree(5,new int[][]{
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        }));
    }
}
