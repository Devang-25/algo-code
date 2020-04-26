package ds.graphs;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mns on 5/30/18.
 */
public class DFS {
    private boolean [] visited = null;
    private int [] edgeTo = null;

    public DFS(Graph g, int s){
        visited = new boolean[g.getNumVertices()];
        edgeTo = new int[g.getNumVertices()];
        Arrays.fill(edgeTo,-1);
        edgeTo[s] = s;
        dfs(g,s);
    }

    private void dfs(Graph g, int v){
        visited[v] = true;
        for(int neighbor : g.getAdjacentVertices(v)){
            if(!visited[neighbor]){
                dfs(g,neighbor);
                edgeTo[neighbor] = v;
            }
        }
    }

    public boolean hasPath(int e){
        return visited[e];
    }

    public Stack<Integer> getPath(int e){
        if(hasPath(e)){
            int curr = e;
            Stack<Integer> path = new Stack<>();

            do{
                path.push(curr);
                curr = edgeTo[curr];
            }while(curr != edgeTo[curr]);

            return path;
        }

        return null;
    }
}
