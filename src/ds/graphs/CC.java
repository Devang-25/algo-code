package ds.graphs;

import java.util.Arrays;

/**
 * Created by mns on 5/30/18.
 */
public class CC {
    private int c;
    private boolean [] visited;
    private int [] ids;
    public CC(Graph g){
        visited = new boolean [g.getNumVertices()];
        ids = new int[g.getNumVertices()];
        c = 0;
        Arrays.fill(visited,false);
        for(int i=0;i<ids.length;i++){
            if(!visited[i]){
                dfs(g,i);
                c++;
            }
        }
    }

    private void dfs(Graph g, int v){
        visited[v] = true;
        ids[v] = c;
        for(int neighbor : g.getAdjacentVertices(v)){
            if(!visited[neighbor]){
                dfs(g,neighbor);
            }
        }
    }

    public int id(int v){
        return ids[v];
    }
    public int getNumberOfComponents() {
        return c;
    }
}
