package ds.graphs;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mns on 5/30/18.
 */
public class BFS {
    private boolean [] visited = null;
    private int [] edgeTo = null;
    private int [] distTo = null;

    public BFS(Graph g, int s){
        visited = new boolean[g.getNumVertices()];
        edgeTo = new int[g.getNumVertices()];
        distTo = new int[g.getNumVertices()];
        Arrays.fill(edgeTo,-1);
        Arrays.fill(distTo,-1);

        edgeTo[s] = s;
        distTo[s] = 0;
        bfs(g,s);
    }

    private void bfs(Graph g, int v){
        visited[v] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(v);

        while(!q.isEmpty()){
            int a = q.poll();
            for(int neighbor : g.getAdjacentVertices(a)){
                if(!visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor] = true;
                    edgeTo[neighbor] = a;
                    distTo[neighbor] = distTo[a]+1;
                }
            }
        }
    }

    public boolean hasPath(int e){
        return visited[e];
    }

    public int getDistance(int e){
        if(hasPath(e)){
            return distTo[e];
        }
        return -1;
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
